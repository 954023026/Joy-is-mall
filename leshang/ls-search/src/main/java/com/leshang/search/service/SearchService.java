package com.leshang.search.service;


import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.search.pojo.Items;
import com.leshang.search.pojo.SearchRequest;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-02 23:14
 */
public interface SearchService {

    Items buildGoods(ZkItem item);

   PageResult<Items> search(SearchRequest request);

 /*    void createOrUpdateIndex(Long spuId);

    void deleteIndex(Long spuId);*/
}
