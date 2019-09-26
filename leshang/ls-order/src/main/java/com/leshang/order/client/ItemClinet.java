package com.leshang.order.client;

import com.leshang.item.api.ItemApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public interface ItemClinet extends ItemApi {

}
