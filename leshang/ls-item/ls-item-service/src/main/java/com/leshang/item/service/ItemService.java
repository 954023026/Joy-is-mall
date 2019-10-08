package com.leshang.item.service;

import com.leshang.common.dto.CartDto;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.common.vo.PageResult;

import java.util.List;

public interface ItemService {

    PageResult<ZkItem> queryItemsPage(Integer page, Integer rows, Integer status, String key, Integer cid);

    PageResult<ZkItem> queryItemsByCidAndPriceSort(Integer page,String way, Long cid);

    ZkItem queryItemsById(Long id);

    List<ZkItem> queryItemByIds(List<Long> ids);

    void decreaseStock(List<CartDto> carts);

    void goodsShelves(Long id,byte status);
}
