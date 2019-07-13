package com.book.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketExample() {
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

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIsNull() {
            addCriterion("target_url is null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIsNotNull() {
            addCriterion("target_url is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlEqualTo(String value) {
            addCriterion("target_url =", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotEqualTo(String value) {
            addCriterion("target_url <>", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThan(String value) {
            addCriterion("target_url >", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("target_url >=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThan(String value) {
            addCriterion("target_url <", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThanOrEqualTo(String value) {
            addCriterion("target_url <=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLike(String value) {
            addCriterion("target_url like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotLike(String value) {
            addCriterion("target_url not like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIn(List<String> values) {
            addCriterion("target_url in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotIn(List<String> values) {
            addCriterion("target_url not in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlBetween(String value1, String value2) {
            addCriterion("target_url between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotBetween(String value1, String value2) {
            addCriterion("target_url not between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andCratedIsNull() {
            addCriterion("crated is null");
            return (Criteria) this;
        }

        public Criteria andCratedIsNotNull() {
            addCriterion("crated is not null");
            return (Criteria) this;
        }

        public Criteria andCratedEqualTo(String value) {
            addCriterion("crated =", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedNotEqualTo(String value) {
            addCriterion("crated <>", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedGreaterThan(String value) {
            addCriterion("crated >", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedGreaterThanOrEqualTo(String value) {
            addCriterion("crated >=", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedLessThan(String value) {
            addCriterion("crated <", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedLessThanOrEqualTo(String value) {
            addCriterion("crated <=", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedLike(String value) {
            addCriterion("crated like", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedNotLike(String value) {
            addCriterion("crated not like", value, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedIn(List<String> values) {
            addCriterion("crated in", values, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedNotIn(List<String> values) {
            addCriterion("crated not in", values, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedBetween(String value1, String value2) {
            addCriterion("crated between", value1, value2, "crated");
            return (Criteria) this;
        }

        public Criteria andCratedNotBetween(String value1, String value2) {
            addCriterion("crated not between", value1, value2, "crated");
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