package com.leshang.item.service.impl;

import com.leshang.item.mapper.ZkItemCatMapper;
import com.leshang.item.mapper.ZkItemMapper;
import com.leshang.item.mapper.ZkStockMapper;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.pojo.ZkStock;
import com.leshang.item.service.ItemCatService;
import com.leshang.item.vo.ZkItemCatVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-20 10:47
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ZkItemCatMapper itemCatMapper;
    @Autowired
    private ZkItemMapper itemMapper;

    @Override
    public ZkItemCat queryCatById(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ZkItemCatVo> queryItemCatByIds(List<Long> ids) {
        return CopyItemCatVo(itemCatMapper.selectByIdList(ids));
    }

    @Override
    public List<ZkItemCatVo> queryAllCat() {
        //获取商品所有类别
        return CopyItemCatVo(itemCatMapper.selectAll());
    }

    //封装需要展示的数据，并查询该分类下商品数量
    private List<ZkItemCatVo> CopyItemCatVo(List<ZkItemCat> cats) {
        List<ZkItemCatVo> list = new ArrayList<>();

        for (ZkItemCat cat : cats) {
            ZkItemCatVo catVo = new ZkItemCatVo();
            BeanUtils.copyProperties(cat, catVo);
            catVo.setItemNum(queryItemCountByCatId(catVo.getId()));
            list.add(catVo);
        }
        return list;
    }

    /**
     * 获取当前商品类别下的商品数量
     *
     * @param cid 类别id
     * @return
     */
    public Integer queryItemCountByCatId(Long cid) {
        Example example = new Example(ZkItem.class);
        //搜索字段过滤
        if (cid != null) {
            example.createCriteria().andEqualTo("cid", cid);
        }
        return itemMapper.selectCountByExample(example);
    }
}
