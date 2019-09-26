package com.leshang.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "zk_areas")
public class ZkAreas implements Serializable {
    @Id
    private Long areaId;
    private Long parentId;
    private String areaName;

    private Long areaType;

}