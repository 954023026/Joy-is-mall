package com.leshang.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leshang.item.mapper.ZkItemCatMapper;
import com.leshang.item.mapper.ZkItemMapper;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.service.ItemService;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.plugin.viewer.frame.IExplorerEmbeddedFrame;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-09 12:08
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ZkItemMapper zkItemMapper;

    @Autowired
    private ZkItemCatMapper zkItemCatMapper;

    @Override
    public List<ZkItem> queryItemAll() {
        PageHelper.startPage(2,14);
        return zkItemMapper.selectAll();
    }

    @Override
    public PageResult<ZkItem> queryItemsPage(Integer page, Integer rows, Integer status, String key, Integer cid) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(ZkItem.class);
        //搜索字段过滤
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }
        //上下架过滤
        if (status != null) {
            criteria.andEqualTo("status", 1);
        }
        //分类过滤
        if (cid != null) {
            criteria.andEqualTo("cid", cid);
        }
        //默认排序
        example.setOrderByClause("created DESC");

        List<ZkItem> zkItems = zkItemMapper.selectByExample(example);
        //判断
        if (CollectionUtils.isEmpty(zkItems)) {
            throw new LyException(ExceptionEnum.ITEM_NOT_FOND);
        }
        //解析分页结果
        PageInfo<ZkItem> info = new PageInfo<>(zkItems);
        return new PageResult<>(info.getTotal(),(long)info.getPages(), zkItems);
    }

    @Override
    public ZkItem finditemById(Long id) {
        ZkItem zkItem=new ZkItem();
        zkItem.setId(id);
        return zkItemMapper.selectOne(zkItem);
    }

    @Override
    public List<ZkItemCat> queryAllCat() {
        List<ZkItemCat> zkItemCats = zkItemCatMapper.selectAll();
        return zkItemCats;
    }
    @Override
    public Integer queryItemCountByCatId(Long cid) {
        Example example = new Example(ZkItem.class);
        //搜索字段过滤
        if (cid != null){
            example.createCriteria().andEqualTo("cid",cid);
        }
        return zkItemMapper.selectCountByExample(example);
    }

    @Override
    public List<ZkItem> queryItemsByCatId(Long id) {
        ZkItem item=new ZkItem();
        item.setCid(id);
        List<ZkItem> itemList = zkItemMapper.select(item);
        return itemList;
    }
}
