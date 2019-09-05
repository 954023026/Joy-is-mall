package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "zk_item_desc")
public class ZkItemDesc implements Serializable {
    @Id
    private Long itemId;

    private Date created;

    private Date updated;

    private String itemDesc;

}