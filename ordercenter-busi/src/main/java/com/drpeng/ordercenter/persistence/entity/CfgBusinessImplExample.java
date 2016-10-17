package com.drpeng.ordercenter.persistence.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgBusinessImplExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public CfgBusinessImplExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBusinessImplIdIsNull() {
            addCriterion("business_impl_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdIsNotNull() {
            addCriterion("business_impl_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdEqualTo(Integer value) {
            addCriterion("business_impl_id =", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdNotEqualTo(Integer value) {
            addCriterion("business_impl_id <>", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdGreaterThan(Integer value) {
            addCriterion("business_impl_id >", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_impl_id >=", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdLessThan(Integer value) {
            addCriterion("business_impl_id <", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_impl_id <=", value, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdIn(List<Integer> values) {
            addCriterion("business_impl_id in", values, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdNotIn(List<Integer> values) {
            addCriterion("business_impl_id not in", values, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdBetween(Integer value1, Integer value2) {
            addCriterion("business_impl_id between", value1, value2, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessImplIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_impl_id not between", value1, value2, "businessImplId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Integer value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Integer value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Integer value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Integer value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Integer> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Integer> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyIsNull() {
            addCriterion("delivery_party is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyIsNotNull() {
            addCriterion("delivery_party is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyEqualTo(Integer value) {
            addCriterion("delivery_party =", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyNotEqualTo(Integer value) {
            addCriterion("delivery_party <>", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyGreaterThan(Integer value) {
            addCriterion("delivery_party >", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_party >=", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyLessThan(Integer value) {
            addCriterion("delivery_party <", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_party <=", value, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyIn(List<Integer> values) {
            addCriterion("delivery_party in", values, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyNotIn(List<Integer> values) {
            addCriterion("delivery_party not in", values, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyBetween(Integer value1, Integer value2) {
            addCriterion("delivery_party between", value1, value2, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andDeliveryPartyNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_party not between", value1, value2, "deliveryParty");
            return (Criteria) this;
        }

        public Criteria andImplClassIsNull() {
            addCriterion("impl_class is null");
            return (Criteria) this;
        }

        public Criteria andImplClassIsNotNull() {
            addCriterion("impl_class is not null");
            return (Criteria) this;
        }

        public Criteria andImplClassEqualTo(String value) {
            addCriterion("impl_class =", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassNotEqualTo(String value) {
            addCriterion("impl_class <>", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassGreaterThan(String value) {
            addCriterion("impl_class >", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassGreaterThanOrEqualTo(String value) {
            addCriterion("impl_class >=", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassLessThan(String value) {
            addCriterion("impl_class <", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassLessThanOrEqualTo(String value) {
            addCriterion("impl_class <=", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassLike(String value) {
            addCriterion("impl_class like", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassNotLike(String value) {
            addCriterion("impl_class not like", value, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassIn(List<String> values) {
            addCriterion("impl_class in", values, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassNotIn(List<String> values) {
            addCriterion("impl_class not in", values, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassBetween(String value1, String value2) {
            addCriterion("impl_class between", value1, value2, "implClass");
            return (Criteria) this;
        }

        public Criteria andImplClassNotBetween(String value1, String value2) {
            addCriterion("impl_class not between", value1, value2, "implClass");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cfg_business_impl
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}