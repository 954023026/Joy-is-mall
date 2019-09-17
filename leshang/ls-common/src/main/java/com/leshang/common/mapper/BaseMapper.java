package com.leshang.common.mapper;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-29 20:07
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, IdListMapper<T,Long>, InsertListMapper<T> {
}
