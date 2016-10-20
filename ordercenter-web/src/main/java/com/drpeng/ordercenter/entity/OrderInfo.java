package com.drpeng.ordercenter.entity;

/**
 * Created by yuyang on 2016/10/14 0014.
 */
public class OrderInfo {
    private String orderNum;
    private String billId;
    private String certCode;
    private String state;
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
