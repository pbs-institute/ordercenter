package com.drpeng.ordercenter.persistence.entity;

import java.util.List;

/**
 * Created by liurl3 on 2016/10/14.
 */
public class Order {
    private OrdOrder ordOrder;
    private List<OrdDetail> ordDetailList;

    public OrdOrder getOrdOrder() {
        return ordOrder;
    }

    public void setOrdOrder(OrdOrder ordOrder) {
        this.ordOrder = ordOrder;
    }

    public List<OrdDetail> getOrdDetailList() {
        return ordDetailList;
    }

    public void setOrdDetailList(List<OrdDetail> ordDetailList) {
        this.ordDetailList = ordDetailList;
    }
}
