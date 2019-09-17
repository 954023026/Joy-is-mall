package com.leshang.item.service;

import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.common.vo.PageResult;

import java.util.List;

public interface ItemService {
    List<ZkItem> queryItemAll();

    PageResult<ZkItem> queryItemsPage(Integer page, Integer rows, Integer status, String key, Integer cid);

    ZkItem finditemById(Long id);

    List<ZkItemCat> queryAllCat();

    Integer queryItemCountByCatId(Long cid);

    List<ZkItem> queryItemsByCatId(Long id);

    List<ZkItem> queryItemsByPriceASC();

    List<ZkItem> queryItemsByPriceDESC();
}
