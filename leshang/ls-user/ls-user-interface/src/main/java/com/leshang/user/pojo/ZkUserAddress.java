package com.leshang.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "zk_user_address")
public class ZkUserAddress implements Serializable {
    @Id
    private Long addressId;
    private Long userId;
    private String realname;
    private String telphone;
    private String province;
    private String city;
    private String area;
    private String street;
    private Integer zip;
    private Boolean isDefault;

    private Date createdTime;

}