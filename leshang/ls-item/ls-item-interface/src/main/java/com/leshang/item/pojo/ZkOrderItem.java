package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 包含所有订单，
 */
@Data
@Table(name = "zk_order_item")
public class ZkOrderItem  implements Serializable {
    @Id
    private String id;

    private Long itemId;   //商品id，从中获取图片..等数据

    private String orderId; //订单id

    private Integer num;

    private Long totalFee;

    // 1_对象对应对象
    // 2_product,order携带更多的数据
    @Transient
    private ZkItem product;
    @Transient
    private ZkOrder order;

}