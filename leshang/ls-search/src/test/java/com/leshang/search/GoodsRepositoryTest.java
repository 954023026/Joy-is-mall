package com.leshang.search;

import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.search.client.ItemClient;
import com.leshang.search.pojo.Items;
import com.leshang.search.repository.GoodsRepository;
import com.leshang.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ItemClient itemClient;
    @Autowired
    private SearchService searchService;

    @Test
    public void testCreateIndex() {

        template.createIndex(Items.class);
        template.putMapping(Items.class);
    }


    @Test
    public void loadData() {
        int page = 1;
        int rows = 100;
        int size = 0;

        //查询spu信息
        do {
            PageResult<ZkItem> result = itemClient.queryItemsPage(page, rows, null, null,null);
            List<ZkItem> spuList = result.getItems();
            if (CollectionUtils.isEmpty(spuList)){
                break;
            }
            //构建成goods
            List<Items> goodsList = spuList.stream()
                    .map(searchService::buildGoods).collect(Collectors.toList());
            //存入索引库
            goodsRepository.saveAll(goodsList);
            //翻页
            page++;
            size = spuList.size();
        } while (size == 100);

    }
}