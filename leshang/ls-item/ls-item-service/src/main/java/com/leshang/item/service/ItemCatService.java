package com.leshang.item.service;

import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.vo.ZkItemCatVo;

import java.util.List;

public interface ItemCatService {


    ZkItemCat queryCatById(Long id);

    List<ZkItemCatVo> queryItemCatByIds(List<Long> ids);

    List<ZkItemCatVo> queryAllCat();

}
