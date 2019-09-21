package com.leshang.search.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.utils.JsonUtils;
import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.vo.ZkItemCatVo;
import com.leshang.search.client.ItemCatClient;
import com.leshang.search.pojo.Items;
import com.leshang.search.pojo.SearchRequest;
import com.leshang.search.pojo.SearchResult;
import com.leshang.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-04 22:19
 */
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ItemCatClient itemCatClient;

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public Items buildGoods(ZkItem item) {
        Long id = item.getId();

        //查询分类
        ZkItemCat zkItemCat = itemCatClient.queryCatById(item.getCid());
        if (zkItemCat == null) {
            log.error(item.getCid().toString());
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOND);
        }

        //搜索字段
        String all = item.getTitle() +","+ StringUtils.join(zkItemCat.getName(), " ");

        if (item == null) {
            throw new LyException(ExceptionEnum.GOODS_SKU_NOT_FOND);
        }

        //构建goods对象
        Items goods = new Items();
        goods.setCid(item.getCid());
        goods.setCreateTime(item.getCreated());
        goods.setId(id);
        goods.setImage(item.getImage());
        goods.setTitle(item.getTitle());
        // 搜索字段，包含标题，分类，品牌，规格，等等
        goods.setAll(all);
        //TODO 所有的可搜索的规格参数
        goods.setPrice(item.getPrice());
        goods.setSubTitle(item.getSellPoint());

        return goods;
    }


    @Override
    public PageResult<Items> search(SearchRequest request) {
        int page = request.getPage() - 1;
        int size = request.getSize();
        //创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //结果过滤
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"id", "subTitle", "price","title","image"}, null));

        //分页
        queryBuilder.withPageable(PageRequest.of(page, size));
        //过滤
        queryBuilder.withQuery(QueryBuilders.matchQuery("all", request.getKey()));

        //聚合分类和品牌
        //聚合分类
        String categoryAggName = "itemCat_agg";
        queryBuilder.addAggregation(AggregationBuilders.terms(categoryAggName).field("cid"));

        //查询
        //Page<Items> result = goodsRepository.search(queryBuilder.build());
        AggregatedPage<Items> result = template.queryForPage(queryBuilder.build(), Items.class);

        //解析结果
        //分页结果解析
        long total = result.getTotalElements();
        Integer totalPages1 = result.getTotalPages();    //失效
        Long totalPages = total % size == 0 ? total / size : total / size + 1;
        List<Items> goodsList = result.getContent();

        //解析聚合结果
        Aggregations aggs = result.getAggregations();
//        List<ZkItemCatVo> zkItemCats = parseCategoryAgg(aggs.get(categoryAggName));

        return new SearchResult(total, totalPages, goodsList);
    }

    private List<ZkItemCatVo> parseCategoryAgg(LongTerms terms) {
        try {
            List<Long> ids = terms.getBuckets()
                    .stream().map(b -> b.getKeyAsNumber().longValue())
                    .collect(Collectors.toList());
            List<ZkItemCatVo> zkItemCats = itemCatClient.queryItemCatByIds(ids);
            return zkItemCats;
        } catch (Exception e) {
            log.error("[搜索服务]查询分类异常：", e);
            return null;
        }
    }


}
