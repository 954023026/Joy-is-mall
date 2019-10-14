package com.leshang.order.service;


import com.leshang.common.vo.PageResult;
import com.leshang.order.dto.OrderDto;
import com.leshang.order.interceptors.PayState;
import com.leshang.order.pojo.Order;
import com.leshang.order.vo.OrderVo;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Long createOrder(OrderDto orderDto);

    Order queryOrderById(Long id);

    String createPayUrl(Long orderId);

    void handleNotify(Map<String, String> result);

    PayState queryOrderStatus(Long orderId);

    PageResult<OrderVo> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc,String status, String key);

    void deleteOrder(String orderId);

    PageResult<OrderVo> queryOrderByUid(String userId);
}
