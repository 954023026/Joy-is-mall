package com.leshang.item.mapper;

import com.leshang.item.pojo.ZkItemCat;
import com.leshang.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ZkItemCatMapper extends BaseMapper<ZkItemCat> {
    @Select("SELECT `name` FROM `zk_item_cat` where id = #{cid}")
    String queryItemCname(@Param("cid") Long cid);
}