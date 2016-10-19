package com.drpeng.ordercenter.activiti.service;

import com.drpeng.ordercenter.placeorder.service.IPlaceOrderService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by lifei13 on 2016/10/14.
 */

@Service
public class RealNameService implements Serializable {


    @Autowired
    IPlaceOrderService placeOrderService;

        /**
     * 人工检查通过
     * @param delegateExecution 流程参数
     */
    public void manualCheckpassed(DelegateExecution delegateExecution){
        System.out.println("检查通过");
        String orderId = (String) delegateExecution.getVariable("ord_order_id");
        placeOrderService.updateOrderStatus(Long.valueOf(orderId),1);
    }

    /**
     * 人工检查失败
     * @param delegateExecution 流程参数
     */
    public void manualCheckRefused(DelegateExecution delegateExecution){
        System.out.println("检查失败");
        Long orderId = (Long) delegateExecution.getVariable("ord_order_id");
        placeOrderService.updateOrderStatus(Long.valueOf(orderId),2);
    }

}
