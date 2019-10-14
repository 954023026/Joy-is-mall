package com.leshang.item.mapper;

import com.leshang.item.pojo.ZkItemCat;
import com.leshang.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZkItemCatMapper extends BaseMapper<ZkItemCat> {
    @Select("SELECT `name` FROM `tb_category` where id = #{cid}")
    String queryItemCname(@Param("cid") Long cid);
    @Select("select id,name,parent_id,is_parent,sort,status FROM tb_category where id>1423")
    List<ZkItemCat> queryAllCat();
}