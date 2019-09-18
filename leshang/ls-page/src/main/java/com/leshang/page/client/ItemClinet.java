package com.leshang.page.client;

import com.leshang.item.api.ItemApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: Adorez
 * @Date: 2019/9/18 9:15
 * @Description:
 */
@FeignClient("item-service")
public interface ItemClinet  extends ItemApi {

}
