package com.leshang.search.client;

import com.leshang.item.api.ItemApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public interface ItemClient extends ItemApi {
}
