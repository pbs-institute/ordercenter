package com.drpeng.ordercenter.placeorder.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.persistence.entity.OrdDetail;
import com.drpeng.ordercenter.persistence.mapper.OrdDetailMapper;
import com.drpeng.ordercenter.persistence.mapper.OrdOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liurl3 on 2016/10/14.
 */
@Component
public class RealNameAuthOrderProcessor extends AbstractOrderProcessorImpl{
    @Override
    public void parseDetailParam(JSONObject jsonObject) throws Exception {
        JSONObject detailOrder = jsonObject.getJSONObject("detail");
        List<OrdDetail> ordDetailList = new ArrayList<OrdDetail>();
        OrdDetail ordDetail = this.transform(detailOrder, "bill_id",true);
        ordDetailList.add(ordDetail);
        OrdDetail ordDetail2 = this.transform(detailOrder, "id_number",true);
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
    }

    @Override
    public Object verifyBusiness() {
        return null;
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
