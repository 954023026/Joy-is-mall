package com.leshang.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "zk_user")
public class ZkUser implements Serializable {
    @Id
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;
    private Date created;
    private Date updated;

    private String address;

    private String stat1;
    private String stat2;
    private String stat3;

}