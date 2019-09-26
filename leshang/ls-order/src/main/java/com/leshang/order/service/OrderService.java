package com.leshang.order.service;


import com.leshang.order.dto.OrderDto;
import com.leshang.order.interceptors.PayState;
import com.leshang.order.pojo.Order;

import java.util.Map;

public interface OrderService {

    Long createOrder(OrderDto orderDto);

    Order queryOrderById(Long id);

    String createPayUrl(Long orderId);

    void handleNotify(Map<String, String> result);

    PayState queryOrderStatus(Long orderId);
}
