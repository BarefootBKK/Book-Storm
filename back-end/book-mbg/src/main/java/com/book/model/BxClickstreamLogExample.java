package com.book.model;

import java.util.ArrayList;
import java.util.List;

public class BxClickstreamLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BxClickstreamLogExample() {
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

        public Criteria andIpaddressIsNull() {
            addCriterion("ipaddress is null");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNotNull() {
            addCriterion("ipaddress is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddressEqualTo(String value) {
            addCriterion("ipaddress =", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotEqualTo(String value) {
            addCriterion("ipaddress <>", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThan(String value) {
            addCriterion("ipaddress >", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddress >=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThan(String value) {
            addCriterion("ipaddress <", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThanOrEqualTo(String value) {
            addCriterion("ipaddress <=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLike(String value) {
            addCriterion("ipaddress like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotLike(String value) {
            addCriterion("ipaddress not like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIn(List<String> values) {
            addCriterion("ipaddress in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotIn(List<String> values) {
            addCriterion("ipaddress not in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressBetween(String value1, String value2) {
            addCriterion("ipaddress between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotBetween(String value1, String value2) {
            addCriterion("ipaddress not between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andUniqueidIsNull() {
            addCriterion("uniqueid is null");
            return (Criteria) this;
        }

        public Criteria andUniqueidIsNotNull() {
            addCriterion("uniqueid is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueidEqualTo(String value) {
            addCriterion("uniqueid =", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidNotEqualTo(String value) {
            addCriterion("uniqueid <>", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidGreaterThan(String value) {
            addCriterion("uniqueid >", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidGreaterThanOrEqualTo(String value) {
            addCriterion("uniqueid >=", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidLessThan(String value) {
            addCriterion("uniqueid <", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidLessThanOrEqualTo(String value) {
            addCriterion("uniqueid <=", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidLike(String value) {
            addCriterion("uniqueid like", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidNotLike(String value) {
            addCriterion("uniqueid not like", value, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidIn(List<String> values) {
            addCriterion("uniqueid in", values, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidNotIn(List<String> values) {
            addCriterion("uniqueid not in", values, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidBetween(String value1, String value2) {
            addCriterion("uniqueid between", value1, value2, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUniqueidNotBetween(String value1, String value2) {
            addCriterion("uniqueid not between", value1, value2, "uniqueid");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIsNull() {
            addCriterion("area_address is null");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIsNotNull() {
            addCriterion("area_address is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAddressEqualTo(String value) {
            addCriterion("area_address =", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotEqualTo(String value) {
            addCriterion("area_address <>", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressGreaterThan(String value) {
            addCriterion("area_address >", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("area_address >=", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLessThan(String value) {
            addCriterion("area_address <", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLessThanOrEqualTo(String value) {
            addCriterion("area_address <=", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLike(String value) {
            addCriterion("area_address like", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotLike(String value) {
            addCriterion("area_address not like", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIn(List<String> values) {
            addCriterion("area_address in", values, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotIn(List<String> values) {
            addCriterion("area_address not in", values, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressBetween(String value1, String value2) {
            addCriterion("area_address between", value1, value2, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotBetween(String value1, String value2) {
            addCriterion("area_address not between", value1, value2, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressIsNull() {
            addCriterion("local_address is null");
            return (Criteria) this;
        }

        public Criteria andLocalAddressIsNotNull() {
            addCriterion("local_address is not null");
            return (Criteria) this;
        }

        public Criteria andLocalAddressEqualTo(String value) {
            addCriterion("local_address =", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressNotEqualTo(String value) {
            addCriterion("local_address <>", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressGreaterThan(String value) {
            addCriterion("local_address >", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("local_address >=", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressLessThan(String value) {
            addCriterion("local_address <", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressLessThanOrEqualTo(String value) {
            addCriterion("local_address <=", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressLike(String value) {
            addCriterion("local_address like", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressNotLike(String value) {
            addCriterion("local_address not like", value, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressIn(List<String> values) {
            addCriterion("local_address in", values, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressNotIn(List<String> values) {
            addCriterion("local_address not in", values, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressBetween(String value1, String value2) {
            addCriterion("local_address between", value1, value2, "localAddress");
            return (Criteria) this;
        }

        public Criteria andLocalAddressNotBetween(String value1, String value2) {
            addCriterion("local_address not between", value1, value2, "localAddress");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNull() {
            addCriterion("browser_type is null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNotNull() {
            addCriterion("browser_type is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeEqualTo(String value) {
            addCriterion("browser_type =", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotEqualTo(String value) {
            addCriterion("browser_type <>", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThan(String value) {
            addCriterion("browser_type >", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("browser_type >=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThan(String value) {
            addCriterion("browser_type <", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThanOrEqualTo(String value) {
            addCriterion("browser_type <=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLike(String value) {
            addCriterion("browser_type like", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotLike(String value) {
            addCriterion("browser_type not like", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIn(List<String> values) {
            addCriterion("browser_type in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotIn(List<String> values) {
            addCriterion("browser_type not in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeBetween(String value1, String value2) {
            addCriterion("browser_type between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotBetween(String value1, String value2) {
            addCriterion("browser_type not between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andOperationsysIsNull() {
            addCriterion("operationsys is null");
            return (Criteria) this;
        }

        public Criteria andOperationsysIsNotNull() {
            addCriterion("operationsys is not null");
            return (Criteria) this;
        }

        public Criteria andOperationsysEqualTo(String value) {
            addCriterion("operationsys =", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysNotEqualTo(String value) {
            addCriterion("operationsys <>", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysGreaterThan(String value) {
            addCriterion("operationsys >", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysGreaterThanOrEqualTo(String value) {
            addCriterion("operationsys >=", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysLessThan(String value) {
            addCriterion("operationsys <", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysLessThanOrEqualTo(String value) {
            addCriterion("operationsys <=", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysLike(String value) {
            addCriterion("operationsys like", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysNotLike(String value) {
            addCriterion("operationsys not like", value, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysIn(List<String> values) {
            addCriterion("operationsys in", values, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysNotIn(List<String> values) {
            addCriterion("operationsys not in", values, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysBetween(String value1, String value2) {
            addCriterion("operationsys between", value1, value2, "operationsys");
            return (Criteria) this;
        }

        public Criteria andOperationsysNotBetween(String value1, String value2) {
            addCriterion("operationsys not between", value1, value2, "operationsys");
            return (Criteria) this;
        }

        public Criteria andReferUrlIsNull() {
            addCriterion("refer_url is null");
            return (Criteria) this;
        }

        public Criteria andReferUrlIsNotNull() {
            addCriterion("refer_url is not null");
            return (Criteria) this;
        }

        public Criteria andReferUrlEqualTo(String value) {
            addCriterion("refer_url =", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlNotEqualTo(String value) {
            addCriterion("refer_url <>", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlGreaterThan(String value) {
            addCriterion("refer_url >", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlGreaterThanOrEqualTo(String value) {
            addCriterion("refer_url >=", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlLessThan(String value) {
            addCriterion("refer_url <", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlLessThanOrEqualTo(String value) {
            addCriterion("refer_url <=", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlLike(String value) {
            addCriterion("refer_url like", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlNotLike(String value) {
            addCriterion("refer_url not like", value, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlIn(List<String> values) {
            addCriterion("refer_url in", values, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlNotIn(List<String> values) {
            addCriterion("refer_url not in", values, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlBetween(String value1, String value2) {
            addCriterion("refer_url between", value1, value2, "referUrl");
            return (Criteria) this;
        }

        public Criteria andReferUrlNotBetween(String value1, String value2) {
            addCriterion("refer_url not between", value1, value2, "referUrl");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andCsvpIsNull() {
            addCriterion("csvp is null");
            return (Criteria) this;
        }

        public Criteria andCsvpIsNotNull() {
            addCriterion("csvp is not null");
            return (Criteria) this;
        }

        public Criteria andCsvpEqualTo(String value) {
            addCriterion("csvp =", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpNotEqualTo(String value) {
            addCriterion("csvp <>", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpGreaterThan(String value) {
            addCriterion("csvp >", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpGreaterThanOrEqualTo(String value) {
            addCriterion("csvp >=", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpLessThan(String value) {
            addCriterion("csvp <", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpLessThanOrEqualTo(String value) {
            addCriterion("csvp <=", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpLike(String value) {
            addCriterion("csvp like", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpNotLike(String value) {
            addCriterion("csvp not like", value, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpIn(List<String> values) {
            addCriterion("csvp in", values, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpNotIn(List<String> values) {
            addCriterion("csvp not in", values, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpBetween(String value1, String value2) {
            addCriterion("csvp between", value1, value2, "csvp");
            return (Criteria) this;
        }

        public Criteria andCsvpNotBetween(String value1, String value2) {
            addCriterion("csvp not between", value1, value2, "csvp");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNull() {
            addCriterion("session_id is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("session_id is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("session_id =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("session_id <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("session_id >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("session_id >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("session_id <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("session_id <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("session_id like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("session_id not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<String> values) {
            addCriterion("session_id in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<String> values) {
            addCriterion("session_id not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("session_id between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("session_id not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessiontimesIsNull() {
            addCriterion("sessiontimes is null");
            return (Criteria) this;
        }

        public Criteria andSessiontimesIsNotNull() {
            addCriterion("sessiontimes is not null");
            return (Criteria) this;
        }

        public Criteria andSessiontimesEqualTo(String value) {
            addCriterion("sessiontimes =", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesNotEqualTo(String value) {
            addCriterion("sessiontimes <>", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesGreaterThan(String value) {
            addCriterion("sessiontimes >", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesGreaterThanOrEqualTo(String value) {
            addCriterion("sessiontimes >=", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesLessThan(String value) {
            addCriterion("sessiontimes <", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesLessThanOrEqualTo(String value) {
            addCriterion("sessiontimes <=", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesLike(String value) {
            addCriterion("sessiontimes like", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesNotLike(String value) {
            addCriterion("sessiontimes not like", value, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesIn(List<String> values) {
            addCriterion("sessiontimes in", values, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesNotIn(List<String> values) {
            addCriterion("sessiontimes not in", values, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesBetween(String value1, String value2) {
            addCriterion("sessiontimes between", value1, value2, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andSessiontimesNotBetween(String value1, String value2) {
            addCriterion("sessiontimes not between", value1, value2, "sessiontimes");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIsNull() {
            addCriterion("receivetime is null");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIsNotNull() {
            addCriterion("receivetime is not null");
            return (Criteria) this;
        }

        public Criteria andReceivetimeEqualTo(String value) {
            addCriterion("receivetime =", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotEqualTo(String value) {
            addCriterion("receivetime <>", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeGreaterThan(String value) {
            addCriterion("receivetime >", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeGreaterThanOrEqualTo(String value) {
            addCriterion("receivetime >=", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeLessThan(String value) {
            addCriterion("receivetime <", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeLessThanOrEqualTo(String value) {
            addCriterion("receivetime <=", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeLike(String value) {
            addCriterion("receivetime like", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotLike(String value) {
            addCriterion("receivetime not like", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIn(List<String> values) {
            addCriterion("receivetime in", values, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotIn(List<String> values) {
            addCriterion("receivetime not in", values, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeBetween(String value1, String value2) {
            addCriterion("receivetime between", value1, value2, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotBetween(String value1, String value2) {
            addCriterion("receivetime not between", value1, value2, "receivetime");
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