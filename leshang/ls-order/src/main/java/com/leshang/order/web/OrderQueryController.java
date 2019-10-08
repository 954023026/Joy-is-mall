package com.leshang.order.web;

import com.leshang.common.vo.PageResult;
import com.leshang.order.service.OrderService;
import com.leshang.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-30 10:57
 */
@RestController
@RequestMapping("orderQuery")
public class OrderQueryController {
    @Autowired
    private OrderService orderService;

    /**
     * 分页查询品牌
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<OrderVo>> queryOrderByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "key", required = false) String key
    ) {
        return ResponseEntity.ok(orderService.queryBrandByPage(page, rows, sortBy, desc,status, key));
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteOrder(@RequestParam(value = "oId",required = true)String orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();

    }
}
