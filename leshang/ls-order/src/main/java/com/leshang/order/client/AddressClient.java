package com.leshang.order.client;

import com.leshang.user.api.AddressApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface AddressClient extends AddressApi {

}

