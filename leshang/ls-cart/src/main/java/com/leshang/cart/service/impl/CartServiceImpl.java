package com.leshang.cart.service.impl;

import com.leshang.cart.interceptor.UserInterceptor;
import com.leshang.cart.pojo.Cart;
import com.leshang.cart.service.CartService;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-18 19:07
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "ls:cart:uid:";

    @Override
    public void addCart(Cart cart) {
        //获取登录用户
        UserInfo user = UserInterceptor.getUser();
        //key
        String key = KEY_PREFIX + user.getId();
        //hashKey
        String hashKey = cart.getId().toString();
        //记录num
        Integer num = cart.getNum();
        BoundHashOperations<String, Object, Object> operation = redisTemplate.boundHashOps(key);
        //判断当前购物车商品是否存在
        if (operation.hasKey(hashKey)) {
            //是，修改数量
            String josn = operation.get(hashKey).toString();
            cart = JsonUtils.parse(josn, Cart.class);
            cart.setNum(cart.getNum() + num);
            if (num > cart.getStock()){
                //超过库存，写入最大库存
                cart.setNum(cart.getStock());
            }
        }

        //写回redis
        operation.put(hashKey, JsonUtils.serialize(cart));
    }

    @Override
    public List<Cart> queryCartList() {
        //获取登录用户
        UserInfo user = UserInterceptor.getUser();
        //key
        String key = KEY_PREFIX + user.getId();

        if (!redisTemplate.hasKey(key)) {
            //key不存在，返回404
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        //获取登录用户的所有购物车
        BoundHashOperations<String, Object, Object> operation = redisTemplate.boundHashOps(key);
        List<Cart> carts = operation.values().stream().map(o -> JsonUtils.parse(o.toString(), Cart.class))
                .collect(Collectors.toList());
        return carts;
    }


    @Override
    public void updateNum(Long skuId, Integer num) {
        //获取登录用户
        UserInfo user = UserInterceptor.getUser();
        //key
        String key = KEY_PREFIX + user.getId();
        //hashKey
        String hashKey = skuId.toString();
        //查询之前购物车数量
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(key);
        //判断是否存在
        if (!operations.hasKey(hashKey)) {
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        //查询
        Cart cart = JsonUtils.parse(operations.get(hashKey).toString(), Cart.class);
        cart.setNum(num);
        if (num > cart.getStock()){
            //超过库存，写入最大库存
            cart.setNum(cart.getStock());
        }
        //写回redis
        operations.put(hashKey, JsonUtils.serialize(cart));
    }

    @Override
    public void deleteCart(Long skuId) {
        //获取登录用户
        UserInfo user = UserInterceptor.getUser();
        //key
        String key = KEY_PREFIX + user.getId();
        //删除
        redisTemplate.opsForHash().delete(key,skuId.toString());
    }

    @Override
    public void clearCart(Cart cart){
        //获取登录用户
        UserInfo user = UserInterceptor.getUser();
        //key
        String key = KEY_PREFIX + user.getId();

        //清空
        redisTemplate.opsForHash().delete(key,cart.toString());
    }

    @Override
    public void addLocal(List<Cart> cart) {
        //获取当前数据，添加到购物车
        cart.stream().forEach(c -> addCart(c));
    }
}
