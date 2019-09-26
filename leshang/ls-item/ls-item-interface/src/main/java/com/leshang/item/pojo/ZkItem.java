package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "zk_item")
public class ZkItem implements Serializable {
    @Id
    private Long id;

    private String title;

    private String sellPoint;

    private Long price;
    @Transient
    private Integer num;

    private String image;

    private Long cid;

    private Byte status;

    private Date created;

    private Date updated;

}