package com.drpeng.ordercenter.placeorder.service;
import com.drpeng.ordercenter.persistence.entity.Order;

/**
 * Created by liurl3 on 2016/10/14.
 */
public interface IPlaceOrderService {
    public void saveOrder(Order order);
    public void updateOrderStatus(long orderId ,int status);
}
