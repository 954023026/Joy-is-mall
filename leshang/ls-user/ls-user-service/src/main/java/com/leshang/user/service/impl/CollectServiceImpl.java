package com.leshang.user.service.impl;

import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.item.pojo.ZkItem;
import com.leshang.user.clinet.ItemClinet;
import com.leshang.user.mapper.CollectMapper;
import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkCollect;
import com.leshang.user.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-10-24 14:54
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ItemClinet itemClinet;
    @Override
    public List<ZkItem> queryCollectByUid(Integer uid) {
        ZkCollect collect = new ZkCollect();
        collect.setCollectUserId(uid);//通过用户id查询该收藏下所有商品

        return collectMapper.select(collect).stream()
                .map(c -> itemClinet.queryItemsById(c.getCollectSpuId().longValue()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCollectByUidAndSpuId(Integer uid, Integer spuId) {
        Example example = new Example(ZkCollect.class);
        example.createCriteria().andEqualTo("collectUserId",uid).andEqualTo("collectSpuId",spuId);
        if (collectMapper.deleteByExample(example) != 1){
            throw new LyException(ExceptionEnum.COLLECTION_DELETE_FAILURE);
        }
    }

    @Override
    public void addCollect(ZkCollect collect) {
        ZkCollect c = new ZkCollect();
        collect.setCollectUserId(collect.getCollectUserId());
        //该用户下收藏所有商品id
        List<Integer> integers = collectMapper.select(c).stream().map(ZkCollect::getCollectSpuId).collect(Collectors.toList());
        if (integers.contains(collect.getCollectSpuId())){
            throw new LyException(ExceptionEnum.COLLECTION_INSERT_CONTAINS);
        }
        if (collectMapper.insert(collect) != 1){
            throw new LyException(ExceptionEnum.COLLECTION_INSERT_FAILURE);
        }
    }
}
