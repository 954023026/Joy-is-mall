package com.leshang.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Document(indexName = "items", type = "docs", shards = 1, replicas = 0)
public class Items {
    @Id
    private Long id; // spuId
    @Field(type = FieldType.text, analyzer = "ik_max_word")
    private String all; // 所有需要被搜索的信息，包含标题，分类，甚至品牌
    @Field(type = FieldType.keyword, index = false)
    private String subTitle;// 卖点
    private String image;// 品牌id
    private Long cid;// 1级分类id
    private Date createTime;// 创建时间
    private Long price;// 价格
    private String title;// 价格
}