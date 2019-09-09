package com.leshang.item.service;

import com.leshang.item.pojo.ZkItem;
import com.leyou.common.vo.PageResult;

import java.util.List;

public interface ItemService {
    List<ZkItem> queryItemAll();

    PageResult<ZkItem> queryItemsPage(Integer page, Integer rows, Integer status, String key, Integer cid);
}
