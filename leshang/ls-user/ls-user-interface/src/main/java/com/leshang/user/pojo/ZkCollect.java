package com.leshang.user.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "zk_collect")
public class ZkCollect implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long collectId;
    private Integer collectSpuId;
    private Integer collectUserId;

}