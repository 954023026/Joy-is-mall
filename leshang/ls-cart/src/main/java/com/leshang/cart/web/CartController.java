package com.leshang.cart.web;

import com.leshang.cart.pojo.Cart;
import com.leshang.cart.service.CartService;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-18 19:03
 */
@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    /**
     * 新增购物车
     * @param cart
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 查询购物车数据
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Cart>> queryCartList(){
        return ResponseEntity.ok(cartService.queryCartList());
    }

    /**
     * 修改购物车商品数量
     * @param skuId
     * @param num
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateCartNum(@RequestParam("id")Long skuId,@RequestParam("num") Integer num){
        cartService.updateNum(skuId,num);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 删除购物车数据
     * @param skuId
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") Long skuId){
        cartService.deleteCart(skuId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Void> clearCart(@RequestBody Cart cart){
        cartService.clearCart(cart);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 合并购物车
     * @param cart
     * @return
     */
    @PostMapping("addLocal")
    public ResponseEntity<Void> addLocal(@RequestBody List<Cart> cart){
        cartService.addLocal(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
