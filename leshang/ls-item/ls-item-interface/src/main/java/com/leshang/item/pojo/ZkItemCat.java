package com.leshang.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tb_category")
public class ZkItemCat implements Serializable {
    @Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String name;

    private Long parentId;

    private Boolean isParent;

    private Integer sort;

    private Integer status;

}