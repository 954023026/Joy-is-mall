package com.leshang.order.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVo {
    private String orderId;// id
    private Integer paymentType; // 支付类型，1、在线支付，2、货到付款
    private Date createTime;// 创建时间
    private String shippingName;// 物流名称

    private Integer status; //1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价'

}

