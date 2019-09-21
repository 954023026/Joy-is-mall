package com.leshang.search.repository;

import com.leshang.search.pojo.Items;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsRepository extends ElasticsearchRepository<Items,Long> {

}
