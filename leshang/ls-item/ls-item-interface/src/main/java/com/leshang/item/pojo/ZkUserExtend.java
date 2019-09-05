package com.leshang.item.pojo;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-07-31 16:05
 */
public class ZkUserExtend extends ZkUser {
    List<ZkOrder> orderList;

    public List<ZkOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ZkOrder> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "ZkUserExtend{" +
                "orderList=" + orderList +
                '}';
    }
}
