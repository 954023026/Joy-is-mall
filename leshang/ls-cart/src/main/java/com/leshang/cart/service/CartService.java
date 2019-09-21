package com.leshang.cart.service;


import com.leshang.cart.pojo.Cart;

import java.util.List;

public interface CartService {
    void addCart(Cart cart);

    List<Cart> queryCartList();

    void updateNum(Long skuId, Integer num);

    void deleteCart(Long skuId);

    void addLocal(List<Cart> cart);

    void clearCart(Cart cart);
}
