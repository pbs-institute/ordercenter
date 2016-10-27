package com.drpeng.ordercenter.placeorder.processor.impl;

import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import com.drpeng.ordercenter.persistence.entity.OrdOrder;
import com.drpeng.ordercenter.persistence.entity.Order;
import com.drpeng.ordercenter.placeorder.processor.OrderProcessor;
import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.placeorder.service.IPlaceOrderService;
import java.util.*;

/**
 * Created by liurl3 on 2016/10/14.
 */
public abstract class AbstractOrderProcessorImpl implements OrderProcessor {
    protected Order order = new Order();
    protected List<Order> subOrders = new ArrayList<Order>();
    protected IPlaceOrderService placeOrderService = (IPlaceOrderService)ApplicationContextHolder.getConext().getBean("placeOrderServiceImpl");
    private IActivitiBaseService activitiBaseService = (IActivitiBaseService)ApplicationContextHolder.getConext().getBean("activitiBaseServiceImpl");
    @Override
    public Map process(JSONObject jsonObject){
        Map map = new HashMap();
        try {
            this.parseBasicParam(jsonObject);
            this.parseDetailParam(jsonObject);
        } catch (Exception e) {
            map.put("return_code","FAIL");
            map.put("return_msg",e.toString());
            return map;
        }
        try {
            List<OrdOrder> ordOrders = this.spiltOrder(order);
            if (ordOrders != null) {
                for (int i = 0; i < ordOrders.size(); i++) {
                    this.verifyBusiAvailability();
                }
            }
            this.calculatePrice();
            this.saveOrder(order, subOrders);
            Map paramMap = this.getStartWorkflowParam(order);
            this.startWorkflow(order,paramMap);
        }catch (Exception e){
            map.put("return_code","SUCCESS");
            map.put("result_code","FAIL");
            map.put("error_code","");
            map.put("error_msg",e.toString());
            e.printStackTrace();
            return map;
        }
        map.put("return_code","SUCCESS");
        map.put("order_number",order.getOrdOrder().getOrderId());
        return map;
    }
    protected void parseBasicParam(JSONObject jsonObject) throws Exception {
        OrdOrder ordOrder = new OrdOrder();
        String appId = this.getParamValueByKey(jsonObject,"app_id",true);
        if(appId != null)
            ordOrder.setAppId(Integer.valueOf(appId));
        String custId = this.getParamValueByKey(jsonObject,"cust_id",true);
        if(custId != null)
            ordOrder.setCustId(Long.valueOf(custId));
        String custName = this.getParamValueByKey(jsonObject, "cust_name", false);
        ordOrder.setCustName(custName);
        String businessId = this.getParamValueByKey(jsonObject, "business_id", true);
        if(businessId != null)
            ordOrder.setBusinessId(Integer.valueOf(businessId));
        String outOrderNumber = this.getParamValueByKey(jsonObject, "out_order_number", false);
        ordOrder.setOutOrderNumber(outOrderNumber);
        String remark = this.getParamValueByKey(jsonObject, "remark", false);
        ordOrder.setRemark(remark);
        ordOrder.setOrderTime(new Date());
        ordOrder.setStatus(1);
        ordOrder.setOrderNumber("2016101416443422");
        //region_id
        order.setOrdOrder(ordOrder);
    }
    protected abstract void parseDetailParam(JSONObject jsonObject) throws Exception;
    protected List<OrdOrder> spiltOrder(Order order){
        OrdOrder ordOrder = order.getOrdOrder();
        if(ordOrder != null)
            ordOrder.setDeliveryParty(1);
        return null;
    }
    protected abstract Object verifyBusiAvailability();

    protected Object calculatePrice(){
        return null;
    }

    protected void saveOrder(Order order,List<Order> subOrders){
        placeOrderService.saveOrder(order);//save base order
        if(subOrders != null && subOrders.size()>0){
            for (Order ord:subOrders){
                placeOrderService.saveOrder(order);//save suborder
            }
        }
    }

    protected abstract Map getStartWorkflowParam(Order order);

    protected void startWorkflow(Order order,Map map){
        activitiBaseService.startProcessByBusi(order.getOrdOrder().getBusinessId(),order.getOrdOrder().getCityId(),map);
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
