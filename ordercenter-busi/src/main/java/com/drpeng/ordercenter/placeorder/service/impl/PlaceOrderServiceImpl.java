package com.drpeng.ordercenter.placeorder.service.impl;

import com.drpeng.ordercenter.persistence.entity.OrdOrder;
import com.drpeng.ordercenter.persistence.entity.OrdOrderExample;
import com.drpeng.ordercenter.persistence.mapper.OrdOrderMapper;
import com.drpeng.ordercenter.placeorder.service.IPlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liurl3 on 2016/10/13.
 */
@Service
public class PlaceOrderServiceImpl implements IPlaceOrderService {
    @Autowired
    private  OrdOrderMapper ordOrderMapper;
    @Autowired
    private OrdOrderExample ordOrderExample;
    @Override
    public int insert(OrdOrder ordOrder) {
        int orderId = 0;
        if(ordOrder != null)
            orderId = ordOrderMapper.insert(ordOrder);
        return orderId;
    }
}
