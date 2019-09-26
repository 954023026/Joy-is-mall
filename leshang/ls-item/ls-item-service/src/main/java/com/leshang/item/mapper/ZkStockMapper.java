package com.leshang.item.mapper;

import com.leshang.common.mapper.BaseMapper;
import com.leshang.item.pojo.ZkStock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-29 19:29
 */
public interface ZkStockMapper extends BaseMapper<ZkStock> {
    @Update("update zk_stock set stock = stock - #{num} where sku_id = #{skuId} and stock >= #{num}")
    int decreaseStock(@Param("skuId") Long skuId, @Param("num") Integer num);
    @Select("select stock from zk_stock where sku_id = #{skuId}")
    int queryItemNumById(@Param("skuId") Long skuId);
}
