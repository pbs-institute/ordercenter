package com.drpeng.ordercenter.placeorder.service.impl;

import com.drpeng.ordercenter.persistence.entity.OrdOrder;
import com.drpeng.ordercenter.persistence.entity.Order;
import com.drpeng.ordercenter.persistence.mapper.OrdDetailMapper;
import com.drpeng.ordercenter.persistence.mapper.OrdOrderMapper;
import com.drpeng.ordercenter.placeorder.service.IPlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liurl3 on 2016/10/13.
 */
@Service
@Transactional
public class PlaceOrderServiceImpl implements IPlaceOrderService {
    @Autowired
    private  OrdOrderMapper ordOrderMapper;
    @Autowired
    private OrdDetailMapper ordDetailMapper;

    @Override
    public void saveOrder(Order order) {
        if(order != null){
            if(order.getOrdOrder() != null)
                ordOrderMapper.insert(order.getOrdOrder());
            if(order.getOrdDetailList() != null && order.getOrdDetailList().size()>0){
                Map map = new HashMap();
                map.put("ordDetails",order.getOrdDetailList());
                map.put("orderId",order.getOrdOrder().getOrderId());
                ordDetailMapper.insertBatch(map);
            }
        }
    }
}
