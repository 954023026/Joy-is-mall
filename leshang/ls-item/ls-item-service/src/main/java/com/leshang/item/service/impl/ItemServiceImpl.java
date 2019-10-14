package com.leshang.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leshang.common.dto.CartDto;
import com.leshang.item.mapper.ZkStockMapper;
import com.leshang.item.mapper.ZkItemCatMapper;
import com.leshang.item.mapper.ZkItemMapper;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.service.ItemService;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
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
    private ZkItemMapper itemMapper;

    @Autowired
    private ZkItemCatMapper itemCatMapper;

    @Autowired
    private ZkStockMapper stockMapper;

    private static final String SORT = "ASC";

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
            criteria.andEqualTo("status", status);
        }
        //分类过滤
        if (cid != null) {
            criteria.andEqualTo("cid", cid);
        }
        //默认排序
        example.setOrderByClause("created DESC");

        List<ZkItem> zkItems = itemMapper.selectByExample(example);
        //判断
        if (CollectionUtils.isEmpty(zkItems)) {
            throw new LyException(ExceptionEnum.ITEM_NOT_FOND);
        }
        //设置该商品库存
        for (ZkItem zkItem : zkItems) {
            zkItem.setNum(stockMapper.queryItemNumById(zkItem.getId()));
            zkItem.setCname(itemCatMapper.queryItemCname(zkItem.getCid()));
        }
        //解析分页结果
        PageInfo<ZkItem> info = new PageInfo<>(zkItems);
        return new PageResult<>(info.getTotal(), (long) info.getPages(), zkItems);
    }

    /**
     * 查找该商品类别下的所有商品,并排序
     *
     * @param cid
     * @return
     */
    @Override
    public PageResult<ZkItem> queryItemsByCidAndPriceSort(Integer page, String way, Long cid) {
        //分页
        PageHelper.startPage(page, 8);
        Example example = new Example(ZkItem.class);
        //搜索字段过滤
        Example.Criteria criteria = example.createCriteria();
        if (null != cid && cid != 0) {
            criteria.andEqualTo("cid", cid);
        }
        //默认排序
        example.setOrderByClause("price " + (StringUtils.isNotBlank(way) ?  way: SORT));
        //查询
        List<ZkItem> zkItems = itemMapper.selectByExample(example);
        //设置库存
        zkItems.forEach(z -> z.setNum(stockMapper.queryItemNumById(z.getId())));
        //解析分页结果
        PageInfo<ZkItem> info = new PageInfo<>(zkItems);
        return new PageResult<>(info.getTotal(), (long) info.getPages(), zkItems);
    }

    @Override
    public ZkItem queryItemsById(Long id) {
        ZkItem zkItem = itemMapper.selectByPrimaryKey(id);
        zkItem.setNum(stockMapper.queryItemNumById(zkItem.getId()));//设置库存
        return zkItem;
    }

    @Override
    public List<ZkItem> queryItemByIds(List<Long> ids) {
        return itemMapper.selectByIdList(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseStock(List<CartDto> carts) {
        for (CartDto cart : carts) {
            //减少库存
            int count = stockMapper.decreaseStock(cart.getId(), cart.getNum());
            if (count != 1) {
                throw new LyException(ExceptionEnum.STOCK_NOT_ENOUGH);
            }
        }
    }

    @Override
    public void goodsShelves(Long id, byte status) {
        //修改商品状态
        ZkItem item = new ZkItem();
        item.setId(id);
        item.setStatus(status);
        itemMapper.updateByPrimaryKeySelective(item);
    }
}
