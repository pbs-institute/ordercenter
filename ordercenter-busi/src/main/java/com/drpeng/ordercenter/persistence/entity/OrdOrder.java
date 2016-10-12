package com.drpeng.ordercenter.persistence.entity;

import java.util.Date;

public class OrdOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.order_id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.order_number
     *
     * @mbggenerated
     */
    private String orderNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.cust_id
     *
     * @mbggenerated
     */
    private Long custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.cust_name
     *
     * @mbggenerated
     */
    private String custName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.business_id
     *
     * @mbggenerated
     */
    private Integer businessId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.order_time
     *
     * @mbggenerated
     */
    private Date orderTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.split_time
     *
     * @mbggenerated
     */
    private Date splitTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.split_reason
     *
     * @mbggenerated
     */
    private String splitReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.delivery_party
     *
     * @mbggenerated
     */
    private Integer deliveryParty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ord_order.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.order_id
     *
     * @return the value of ord_order.order_id
     *
     * @mbggenerated
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.order_id
     *
     * @param orderId the value for ord_order.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.order_number
     *
     * @return the value of ord_order.order_number
     *
     * @mbggenerated
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.order_number
     *
     * @param orderNumber the value for ord_order.order_number
     *
     * @mbggenerated
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.cust_id
     *
     * @return the value of ord_order.cust_id
     *
     * @mbggenerated
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.cust_id
     *
     * @param custId the value for ord_order.cust_id
     *
     * @mbggenerated
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.cust_name
     *
     * @return the value of ord_order.cust_name
     *
     * @mbggenerated
     */
    public String getCustName() {
        return custName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.cust_name
     *
     * @param custName the value for ord_order.cust_name
     *
     * @mbggenerated
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.business_id
     *
     * @return the value of ord_order.business_id
     *
     * @mbggenerated
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.business_id
     *
     * @param businessId the value for ord_order.business_id
     *
     * @mbggenerated
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.order_time
     *
     * @return the value of ord_order.order_time
     *
     * @mbggenerated
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.order_time
     *
     * @param orderTime the value for ord_order.order_time
     *
     * @mbggenerated
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.status
     *
     * @return the value of ord_order.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.status
     *
     * @param status the value for ord_order.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.split_time
     *
     * @return the value of ord_order.split_time
     *
     * @mbggenerated
     */
    public Date getSplitTime() {
        return splitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.split_time
     *
     * @param splitTime the value for ord_order.split_time
     *
     * @mbggenerated
     */
    public void setSplitTime(Date splitTime) {
        this.splitTime = splitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.split_reason
     *
     * @return the value of ord_order.split_reason
     *
     * @mbggenerated
     */
    public String getSplitReason() {
        return splitReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.split_reason
     *
     * @param splitReason the value for ord_order.split_reason
     *
     * @mbggenerated
     */
    public void setSplitReason(String splitReason) {
        this.splitReason = splitReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.delivery_party
     *
     * @return the value of ord_order.delivery_party
     *
     * @mbggenerated
     */
    public Integer getDeliveryParty() {
        return deliveryParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.delivery_party
     *
     * @param deliveryParty the value for ord_order.delivery_party
     *
     * @mbggenerated
     */
    public void setDeliveryParty(Integer deliveryParty) {
        this.deliveryParty = deliveryParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ord_order.remark
     *
     * @return the value of ord_order.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ord_order.remark
     *
     * @param remark the value for ord_order.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}