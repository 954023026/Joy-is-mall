package com.leshang.user.clinet;

import com.leshang.item.api.ItemApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public interface ItemClinet extends ItemApi {

}
