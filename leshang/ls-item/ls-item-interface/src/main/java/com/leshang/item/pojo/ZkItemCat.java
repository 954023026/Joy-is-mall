package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "zk_item_cat")
public class ZkItemCat implements Serializable {
    @Id
    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;

    private Date created;

    private Date updated;

    @Transient
    List<ZkItem> itemList;

}