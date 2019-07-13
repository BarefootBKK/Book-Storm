package com.book.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdIsNull() {
            addCriterion("store_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdIsNotNull() {
            addCriterion("store_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdEqualTo(Long value) {
            addCriterion("store_manager_id =", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdNotEqualTo(Long value) {
            addCriterion("store_manager_id <>", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdGreaterThan(Long value) {
            addCriterion("store_manager_id >", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_manager_id >=", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdLessThan(Long value) {
            addCriterion("store_manager_id <", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdLessThanOrEqualTo(Long value) {
            addCriterion("store_manager_id <=", value, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdIn(List<Long> values) {
            addCriterion("store_manager_id in", values, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdNotIn(List<Long> values) {
            addCriterion("store_manager_id not in", values, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdBetween(Long value1, Long value2) {
            addCriterion("store_manager_id between", value1, value2, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIdNotBetween(Long value1, Long value2) {
            addCriterion("store_manager_id not between", value1, value2, "storeManagerId");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumIsNull() {
            addCriterion("store_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumIsNotNull() {
            addCriterion("store_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumEqualTo(String value) {
            addCriterion("store_phone_num =", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumNotEqualTo(String value) {
            addCriterion("store_phone_num <>", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumGreaterThan(String value) {
            addCriterion("store_phone_num >", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone_num >=", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumLessThan(String value) {
            addCriterion("store_phone_num <", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumLessThanOrEqualTo(String value) {
            addCriterion("store_phone_num <=", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumLike(String value) {
            addCriterion("store_phone_num like", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumNotLike(String value) {
            addCriterion("store_phone_num not like", value, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumIn(List<String> values) {
            addCriterion("store_phone_num in", values, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumNotIn(List<String> values) {
            addCriterion("store_phone_num not in", values, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumBetween(String value1, String value2) {
            addCriterion("store_phone_num between", value1, value2, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNumNotBetween(String value1, String value2) {
            addCriterion("store_phone_num not between", value1, value2, "storePhoneNum");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIsNull() {
            addCriterion("store_telephone is null");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIsNotNull() {
            addCriterion("store_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneEqualTo(String value) {
            addCriterion("store_telephone =", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotEqualTo(String value) {
            addCriterion("store_telephone <>", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneGreaterThan(String value) {
            addCriterion("store_telephone >", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_telephone >=", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLessThan(String value) {
            addCriterion("store_telephone <", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLessThanOrEqualTo(String value) {
            addCriterion("store_telephone <=", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLike(String value) {
            addCriterion("store_telephone like", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotLike(String value) {
            addCriterion("store_telephone not like", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIn(List<String> values) {
            addCriterion("store_telephone in", values, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotIn(List<String> values) {
            addCriterion("store_telephone not in", values, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneBetween(String value1, String value2) {
            addCriterion("store_telephone between", value1, value2, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotBetween(String value1, String value2) {
            addCriterion("store_telephone not between", value1, value2, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andStorePositionIsNull() {
            addCriterion("store_position is null");
            return (Criteria) this;
        }

        public Criteria andStorePositionIsNotNull() {
            addCriterion("store_position is not null");
            return (Criteria) this;
        }

        public Criteria andStorePositionEqualTo(String value) {
            addCriterion("store_position =", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionNotEqualTo(String value) {
            addCriterion("store_position <>", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionGreaterThan(String value) {
            addCriterion("store_position >", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionGreaterThanOrEqualTo(String value) {
            addCriterion("store_position >=", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionLessThan(String value) {
            addCriterion("store_position <", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionLessThanOrEqualTo(String value) {
            addCriterion("store_position <=", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionLike(String value) {
            addCriterion("store_position like", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionNotLike(String value) {
            addCriterion("store_position not like", value, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionIn(List<String> values) {
            addCriterion("store_position in", values, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionNotIn(List<String> values) {
            addCriterion("store_position not in", values, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionBetween(String value1, String value2) {
            addCriterion("store_position between", value1, value2, "storePosition");
            return (Criteria) this;
        }

        public Criteria andStorePositionNotBetween(String value1, String value2) {
            addCriterion("store_position not between", value1, value2, "storePosition");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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