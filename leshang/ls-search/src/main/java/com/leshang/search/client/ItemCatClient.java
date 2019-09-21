package com.leshang.search.client;

import com.leshang.item.api.ItemCatApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-20 10:54
 */
@FeignClient("item-service")
public interface ItemCatClient extends ItemCatApi {
}
