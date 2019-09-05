package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
@Data
@Table(name = "zk_order")
public class ZkOrder implements Serializable {
    @Id
    private String orderId;  //订单id

    private String payment;

    private Integer paymentType;

    private String postFee;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private String shippingName;

    private String shippingCode;

    private Long userId;

    private String buyerMessage;

    private String buyerNick;

    private Integer buyerRate;

    // 1_程序对象和对象发生关系,而不是对象和对象的属性发生关系
    // 2_设计Order目的:让order携带订单上的数据向service,dao传递,user对象是可以携带更多的数据
    @Transient  //不储存该字段进入数据库
    private ZkUser user;

    // 程序中体现订单对象和订单项之间关系,我们再项目中的部分功能中有类似的需求:查询订单的同时还需要获取订单下所有的订单项
    @Transient
    private List<ZkOrderItem> list = new ArrayList<ZkOrderItem>();
    @Transient
    private String stringstatus;

}