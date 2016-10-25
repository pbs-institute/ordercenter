package com.drpeng.ordercenter.placeorder.controller;


import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.common.service.ICfgService;
import com.drpeng.ordercenter.persistence.entity.CfgBusiness;
import com.drpeng.ordercenter.placeorder.processor.impl.AbstractOrderProcessorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liurl3 on 2016/10/12.
 */
@RestController
@RequestMapping("/order")
public class PlaceOrderController {
    @Autowired
    private ICfgService cfgService;
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public Map<String,Object> placeOrder(@RequestBody JSONObject orderJson){
        Map<String,Object> rtnMap = new HashMap<String,Object>();
        String businessId = null;
        AbstractOrderProcessorImpl orderImpl = null;
        try {
            businessId = this.getParamValueByKey(orderJson,"business_id",true);
            CfgBusiness cfgBusiness = cfgService.findCfgBusiness(Integer.valueOf(businessId));
            if(cfgBusiness != null){
                String ordImplClass = cfgBusiness.getOrderImplClass();
                if(ordImplClass != null && !ordImplClass.isEmpty()) {
                    orderImpl = (AbstractOrderProcessorImpl) Class.forName(ordImplClass).newInstance();
                }
            }else {
                rtnMap.put("return_code","FAIL");
                rtnMap.put("return_msg","The businessId:" + businessId + " not be configuration");
            }
        } catch (Exception e) {
            rtnMap.put("return_code","FAIL");
            rtnMap.put("return_msg",e.toString());
            e.printStackTrace();
        }
        if(orderImpl != null)
            rtnMap = orderImpl.processor(orderJson);
        return rtnMap;
    }
    private String getParamValueByKey(JSONObject jsonObject,String key,boolean isEmpty) throws Exception {
        Object obj = jsonObject.get(key);
        String retunString = null;
        if(obj == null){
            if(isEmpty)
                throw new Exception("param " + key + " cannot be empty");
        }else {
            retunString = String.valueOf(obj);
        }
        return retunString;
    }
}
