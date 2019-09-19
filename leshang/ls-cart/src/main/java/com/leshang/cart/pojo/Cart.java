package com.leshang.cart.pojo;

import lombok.Data;

@Data
public class Cart {

    private Long userId;// 用户id
    private Long id;// 商品id
    private String title;// 标题
    private String image;// 图片
    private Long price;// 加入购物车时的价格
    private Integer num;// 购买数量
    private Integer stock;  //商品库存
    private String sellPoint;// 商品规格参数

}