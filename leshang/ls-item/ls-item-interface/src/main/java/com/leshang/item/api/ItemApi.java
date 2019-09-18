package com.leshang.item.api;

import com.leshang.item.pojo.ZkItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Adorez
 * @Date: 2019/9/18 9:14
 * @Description:
 */
public interface ItemApi {
    /**
     * 获取商品详情
     * @param id 商品id
     * @return
     */
    @GetMapping("item/findItemById/{id}")
    public ZkItem queryItemsById(@PathVariable("id") Long id);

}
