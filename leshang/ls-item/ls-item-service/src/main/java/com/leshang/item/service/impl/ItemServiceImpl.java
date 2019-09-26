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
            criteria.andEqualTo("status", 1);
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
        zkItems.forEach(c -> c.setNum(stockMapper.queryItemNumById(c.getId())));
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
    public List<ZkItem> queryItemsByCidAndPriceSort(String way, Long cid) {
        Example example = new Example(ZkItem.class);
        //搜索字段过滤
        Example.Criteria criteria = example.createCriteria();
        if (null != cid && cid != 0) {
            criteria.andEqualTo("cid", cid);
        }
        //默认排序
        example.setOrderByClause("price " + way);
        return itemMapper.selectByExample(example);
    }

    @Override
    public List<ZkItem> queryItemsByCidAndPriceSort(Long cid) {
        return queryItemsByCidAndPriceSort(SORT,cid);
    }

    @Override
    public ZkItem queryItemsById(Long id) {
        return itemMapper.selectByPrimaryKey(id);
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
}
