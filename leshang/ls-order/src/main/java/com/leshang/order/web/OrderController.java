package com.leshang.order.web;

import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.order.dto.OrderDto;
import com.leshang.order.pojo.Order;
import com.leshang.order.service.OrderService;
import com.leshang.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-21 11:31
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody OrderDto orderDto) {
        //创建订单
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }


    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryOrderById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.queryOrderById(id));
    }


    /**
     * 创建支付链接
     * @param orderId
     * @return
     */
    @GetMapping("url/{id}")
    public ResponseEntity<String> createPayUrl(@PathVariable("id") Long orderId){
        return ResponseEntity.ok(orderService.createPayUrl(orderId));
    }

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    @GetMapping("state/{id}")
    public ResponseEntity<Integer> queryOrderStatus(@PathVariable("id")Long orderId){
        return ResponseEntity.ok(orderService.queryOrderStatus(orderId).getValue());
    }
}
