package com.leshang.item.mapper;

import com.leshang.item.pojo.ZkItem;
import com.leyou.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZkItemMapper  extends BaseMapper<ZkItem> {

    @Select("SELECT * FROM zk_item ORDER BY price ASC")
     List<ZkItem> queryItemsByPriceASC();

    @Select("SELECT * FROM zk_item ORDER BY price DESC")
    List<ZkItem> queryItemsByPriceDESC();
}