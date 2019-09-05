package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "zk_cart_info")
public class ZkCartInfo  implements Serializable {
    @Id
    private String id;

    private String itemId;

    private Integer num;

    private Long totalFee;

}