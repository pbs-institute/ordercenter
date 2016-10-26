package com.drpeng.ordercenter.placeorder.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import com.drpeng.ordercenter.persistence.entity.OrdDetail;
import com.drpeng.ordercenter.persistence.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurl3 on 2016/10/14.
 */
public class RealNameAuthOrderProcessorImpl extends AbstractOrderProcessorImpl{
    private String billId = "";
    private String idNumber = "";
    private String name = "";
    private String frontSidePhoto = "";
    private String backSidePhoto = "";
    private String handHeldPhoto = "";
    private long orderId = 0l;
    @Override
    public void parseDetailParam(JSONObject jsonObject) throws Exception {
        JSONObject detailOrder = jsonObject.getJSONObject("detail");
        List<OrdDetail> ordDetailList = new ArrayList<OrdDetail>();
        OrdDetail ordDetail = this.transform(detailOrder, "bill_id",true);
        ordDetailList.add(ordDetail);
        OrdDetail ordDetail2 = this.transform(detailOrder, "id_number", true);
        ordDetailList.add(ordDetail2);
        OrdDetail ordDetail3 = this.transform(detailOrder, "name",true);
        ordDetailList.add(ordDetail3);
        OrdDetail ordDetail4 = this.transform(detailOrder,"front_side_photo",true);
        ordDetailList.add(ordDetail4);
        OrdDetail ordDetail5 = this.transform(detailOrder, "back_side_photo",true);
        ordDetailList.add(ordDetail5);
        OrdDetail ordDetail6 = this.transform(detailOrder,"hand_held_photo",true);
        ordDetailList.add(ordDetail6);
        order.setOrdDetailList(ordDetailList);
        billId = ordDetail.getDetailValue();
        idNumber = ordDetail2.getDetailValue();
        name = ordDetail3.getDetailValue();
        frontSidePhoto = ordDetail4.getDetailValue();
        backSidePhoto = ordDetail5.getDetailValue();
        handHeldPhoto = ordDetail6.getDetailValue();
    }

    @Override
    public Object verifyBusiAvailability() {
        return null;
    }

    @Override
    protected Map getStartWorkflowParam(Order order) {
        Map map = new HashMap();
        map.put("bill_id",billId);
        map.put("id_number",idNumber);
        map.put("name",name);
        map.put("front_side_photo",frontSidePhoto);
        map.put("back_side_photo",backSidePhoto);
        map.put("hand_held_photo",handHeldPhoto);
        map.put("ord_order_id", order.getOrdOrder().getOrderId());
        return map;
    }


    private OrdDetail transform(JSONObject jsonObject,String paramKey,boolean isEmpty) throws Exception {
        Object backSidePhotoObj = jsonObject.get(paramKey);
        OrdDetail ordDetail = new OrdDetail();
        if(backSidePhotoObj == null){
            if(isEmpty) {
                throw new Exception("param" + paramKey + " cannot be empty");
            }
        }else {
            ordDetail.setDetailKey(paramKey);
            ordDetail.setDetailValue(String.valueOf(backSidePhotoObj));
            ordDetail.setDetailValueType(1);
            ordDetail.setParentDetailId(0l);
        }
        return ordDetail;
    }
}
