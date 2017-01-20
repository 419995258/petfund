package com.wdkj.xyfund.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HelpApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HelpApplyExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andChildIsNull() {
            addCriterion("child is null");
            return (Criteria) this;
        }

        public Criteria andChildIsNotNull() {
            addCriterion("child is not null");
            return (Criteria) this;
        }

        public Criteria andChildEqualTo(String value) {
            addCriterion("child =", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildNotEqualTo(String value) {
            addCriterion("child <>", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildGreaterThan(String value) {
            addCriterion("child >", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildGreaterThanOrEqualTo(String value) {
            addCriterion("child >=", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildLessThan(String value) {
            addCriterion("child <", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildLessThanOrEqualTo(String value) {
            addCriterion("child <=", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildLike(String value) {
            addCriterion("child like", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildNotLike(String value) {
            addCriterion("child not like", value, "child");
            return (Criteria) this;
        }

        public Criteria andChildIn(List<String> values) {
            addCriterion("child in", values, "child");
            return (Criteria) this;
        }

        public Criteria andChildNotIn(List<String> values) {
            addCriterion("child not in", values, "child");
            return (Criteria) this;
        }

        public Criteria andChildBetween(String value1, String value2) {
            addCriterion("child between", value1, value2, "child");
            return (Criteria) this;
        }

        public Criteria andChildNotBetween(String value1, String value2) {
            addCriterion("child not between", value1, value2, "child");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andGuardianIsNull() {
            addCriterion("guardian is null");
            return (Criteria) this;
        }

        public Criteria andGuardianIsNotNull() {
            addCriterion("guardian is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianEqualTo(String value) {
            addCriterion("guardian =", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotEqualTo(String value) {
            addCriterion("guardian <>", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianGreaterThan(String value) {
            addCriterion("guardian >", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianGreaterThanOrEqualTo(String value) {
            addCriterion("guardian >=", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLessThan(String value) {
            addCriterion("guardian <", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLessThanOrEqualTo(String value) {
            addCriterion("guardian <=", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLike(String value) {
            addCriterion("guardian like", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotLike(String value) {
            addCriterion("guardian not like", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianIn(List<String> values) {
            addCriterion("guardian in", values, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotIn(List<String> values) {
            addCriterion("guardian not in", values, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianBetween(String value1, String value2) {
            addCriterion("guardian between", value1, value2, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotBetween(String value1, String value2) {
            addCriterion("guardian not between", value1, value2, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeIsNull() {
            addCriterion("guardian_age is null");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeIsNotNull() {
            addCriterion("guardian_age is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeEqualTo(Integer value) {
            addCriterion("guardian_age =", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeNotEqualTo(Integer value) {
            addCriterion("guardian_age <>", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeGreaterThan(Integer value) {
            addCriterion("guardian_age >", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("guardian_age >=", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeLessThan(Integer value) {
            addCriterion("guardian_age <", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeLessThanOrEqualTo(Integer value) {
            addCriterion("guardian_age <=", value, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeIn(List<Integer> values) {
            addCriterion("guardian_age in", values, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeNotIn(List<Integer> values) {
            addCriterion("guardian_age not in", values, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeBetween(Integer value1, Integer value2) {
            addCriterion("guardian_age between", value1, value2, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andGuardianAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("guardian_age not between", value1, value2, "guardianAge");
            return (Criteria) this;
        }

        public Criteria andRelaApplyIsNull() {
            addCriterion("rela_apply is null");
            return (Criteria) this;
        }

        public Criteria andRelaApplyIsNotNull() {
            addCriterion("rela_apply is not null");
            return (Criteria) this;
        }

        public Criteria andRelaApplyEqualTo(String value) {
            addCriterion("rela_apply =", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyNotEqualTo(String value) {
            addCriterion("rela_apply <>", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyGreaterThan(String value) {
            addCriterion("rela_apply >", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyGreaterThanOrEqualTo(String value) {
            addCriterion("rela_apply >=", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyLessThan(String value) {
            addCriterion("rela_apply <", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyLessThanOrEqualTo(String value) {
            addCriterion("rela_apply <=", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyLike(String value) {
            addCriterion("rela_apply like", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyNotLike(String value) {
            addCriterion("rela_apply not like", value, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyIn(List<String> values) {
            addCriterion("rela_apply in", values, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyNotIn(List<String> values) {
            addCriterion("rela_apply not in", values, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyBetween(String value1, String value2) {
            addCriterion("rela_apply between", value1, value2, "relaApply");
            return (Criteria) this;
        }

        public Criteria andRelaApplyNotBetween(String value1, String value2) {
            addCriterion("rela_apply not between", value1, value2, "relaApply");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumIsNull() {
            addCriterion("guardian_id_num is null");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumIsNotNull() {
            addCriterion("guardian_id_num is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumEqualTo(String value) {
            addCriterion("guardian_id_num =", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumNotEqualTo(String value) {
            addCriterion("guardian_id_num <>", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumGreaterThan(String value) {
            addCriterion("guardian_id_num >", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_id_num >=", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumLessThan(String value) {
            addCriterion("guardian_id_num <", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumLessThanOrEqualTo(String value) {
            addCriterion("guardian_id_num <=", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumLike(String value) {
            addCriterion("guardian_id_num like", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumNotLike(String value) {
            addCriterion("guardian_id_num not like", value, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumIn(List<String> values) {
            addCriterion("guardian_id_num in", values, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumNotIn(List<String> values) {
            addCriterion("guardian_id_num not in", values, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumBetween(String value1, String value2) {
            addCriterion("guardian_id_num between", value1, value2, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumNotBetween(String value1, String value2) {
            addCriterion("guardian_id_num not between", value1, value2, "guardianIdNum");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNull() {
            addCriterion("occupation is null");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNotNull() {
            addCriterion("occupation is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationEqualTo(String value) {
            addCriterion("occupation =", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("occupation <>", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("occupation >", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("occupation >=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThan(String value) {
            addCriterion("occupation <", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("occupation <=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLike(String value) {
            addCriterion("occupation like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotLike(String value) {
            addCriterion("occupation not like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationIn(List<String> values) {
            addCriterion("occupation in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("occupation not in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("occupation not between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andIsAgrIsNull() {
            addCriterion("is_agr is null");
            return (Criteria) this;
        }

        public Criteria andIsAgrIsNotNull() {
            addCriterion("is_agr is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgrEqualTo(Integer value) {
            addCriterion("is_agr =", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrNotEqualTo(Integer value) {
            addCriterion("is_agr <>", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrGreaterThan(Integer value) {
            addCriterion("is_agr >", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_agr >=", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrLessThan(Integer value) {
            addCriterion("is_agr <", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrLessThanOrEqualTo(Integer value) {
            addCriterion("is_agr <=", value, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrIn(List<Integer> values) {
            addCriterion("is_agr in", values, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrNotIn(List<Integer> values) {
            addCriterion("is_agr not in", values, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrBetween(Integer value1, Integer value2) {
            addCriterion("is_agr between", value1, value2, "isAgr");
            return (Criteria) this;
        }

        public Criteria andIsAgrNotBetween(Integer value1, Integer value2) {
            addCriterion("is_agr not between", value1, value2, "isAgr");
            return (Criteria) this;
        }

        public Criteria andFamilysIsNull() {
            addCriterion("familys is null");
            return (Criteria) this;
        }

        public Criteria andFamilysIsNotNull() {
            addCriterion("familys is not null");
            return (Criteria) this;
        }

        public Criteria andFamilysEqualTo(Integer value) {
            addCriterion("familys =", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysNotEqualTo(Integer value) {
            addCriterion("familys <>", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysGreaterThan(Integer value) {
            addCriterion("familys >", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysGreaterThanOrEqualTo(Integer value) {
            addCriterion("familys >=", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysLessThan(Integer value) {
            addCriterion("familys <", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysLessThanOrEqualTo(Integer value) {
            addCriterion("familys <=", value, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysIn(List<Integer> values) {
            addCriterion("familys in", values, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysNotIn(List<Integer> values) {
            addCriterion("familys not in", values, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysBetween(Integer value1, Integer value2) {
            addCriterion("familys between", value1, value2, "familys");
            return (Criteria) this;
        }

        public Criteria andFamilysNotBetween(Integer value1, Integer value2) {
            addCriterion("familys not between", value1, value2, "familys");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamIsNull() {
            addCriterion("income_stream is null");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamIsNotNull() {
            addCriterion("income_stream is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamEqualTo(String value) {
            addCriterion("income_stream =", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamNotEqualTo(String value) {
            addCriterion("income_stream <>", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamGreaterThan(String value) {
            addCriterion("income_stream >", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamGreaterThanOrEqualTo(String value) {
            addCriterion("income_stream >=", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamLessThan(String value) {
            addCriterion("income_stream <", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamLessThanOrEqualTo(String value) {
            addCriterion("income_stream <=", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamLike(String value) {
            addCriterion("income_stream like", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamNotLike(String value) {
            addCriterion("income_stream not like", value, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamIn(List<String> values) {
            addCriterion("income_stream in", values, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamNotIn(List<String> values) {
            addCriterion("income_stream not in", values, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamBetween(String value1, String value2) {
            addCriterion("income_stream between", value1, value2, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andIncomeStreamNotBetween(String value1, String value2) {
            addCriterion("income_stream not between", value1, value2, "incomeStream");
            return (Criteria) this;
        }

        public Criteria andYearIncomeIsNull() {
            addCriterion("year_income is null");
            return (Criteria) this;
        }

        public Criteria andYearIncomeIsNotNull() {
            addCriterion("year_income is not null");
            return (Criteria) this;
        }

        public Criteria andYearIncomeEqualTo(BigDecimal value) {
            addCriterion("year_income =", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotEqualTo(BigDecimal value) {
            addCriterion("year_income <>", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeGreaterThan(BigDecimal value) {
            addCriterion("year_income >", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_income >=", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeLessThan(BigDecimal value) {
            addCriterion("year_income <", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_income <=", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeIn(List<BigDecimal> values) {
            addCriterion("year_income in", values, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotIn(List<BigDecimal> values) {
            addCriterion("year_income not in", values, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_income between", value1, value2, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_income not between", value1, value2, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeIsNull() {
            addCriterion("people_year_income is null");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeIsNotNull() {
            addCriterion("people_year_income is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeEqualTo(BigDecimal value) {
            addCriterion("people_year_income =", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeNotEqualTo(BigDecimal value) {
            addCriterion("people_year_income <>", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeGreaterThan(BigDecimal value) {
            addCriterion("people_year_income >", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("people_year_income >=", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeLessThan(BigDecimal value) {
            addCriterion("people_year_income <", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("people_year_income <=", value, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeIn(List<BigDecimal> values) {
            addCriterion("people_year_income in", values, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeNotIn(List<BigDecimal> values) {
            addCriterion("people_year_income not in", values, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("people_year_income between", value1, value2, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andPeopleYearIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("people_year_income not between", value1, value2, "peopleYearIncome");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIsNull() {
            addCriterion("diagnosis is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIsNotNull() {
            addCriterion("diagnosis is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisEqualTo(String value) {
            addCriterion("diagnosis =", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotEqualTo(String value) {
            addCriterion("diagnosis <>", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThan(String value) {
            addCriterion("diagnosis >", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis >=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThan(String value) {
            addCriterion("diagnosis <", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThanOrEqualTo(String value) {
            addCriterion("diagnosis <=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLike(String value) {
            addCriterion("diagnosis like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotLike(String value) {
            addCriterion("diagnosis not like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIn(List<String> values) {
            addCriterion("diagnosis in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotIn(List<String> values) {
            addCriterion("diagnosis not in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisBetween(String value1, String value2) {
            addCriterion("diagnosis between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotBetween(String value1, String value2) {
            addCriterion("diagnosis not between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNull() {
            addCriterion("hospital is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("hospital is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("hospital =", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("hospital <>", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("hospital >", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("hospital >=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("hospital <", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("hospital <=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLike(String value) {
            addCriterion("hospital like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("hospital not like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalIn(List<String> values) {
            addCriterion("hospital in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotIn(List<String> values) {
            addCriterion("hospital not in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("hospital between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("hospital not between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNull() {
            addCriterion("doctor is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNotNull() {
            addCriterion("doctor is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorEqualTo(String value) {
            addCriterion("doctor =", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotEqualTo(String value) {
            addCriterion("doctor <>", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThan(String value) {
            addCriterion("doctor >", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("doctor >=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThan(String value) {
            addCriterion("doctor <", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThanOrEqualTo(String value) {
            addCriterion("doctor <=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLike(String value) {
            addCriterion("doctor like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotLike(String value) {
            addCriterion("doctor not like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorIn(List<String> values) {
            addCriterion("doctor in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotIn(List<String> values) {
            addCriterion("doctor not in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorBetween(String value1, String value2) {
            addCriterion("doctor between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotBetween(String value1, String value2) {
            addCriterion("doctor not between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorTelIsNull() {
            addCriterion("doctor_tel is null");
            return (Criteria) this;
        }

        public Criteria andDoctorTelIsNotNull() {
            addCriterion("doctor_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorTelEqualTo(String value) {
            addCriterion("doctor_tel =", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelNotEqualTo(String value) {
            addCriterion("doctor_tel <>", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelGreaterThan(String value) {
            addCriterion("doctor_tel >", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_tel >=", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelLessThan(String value) {
            addCriterion("doctor_tel <", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelLessThanOrEqualTo(String value) {
            addCriterion("doctor_tel <=", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelLike(String value) {
            addCriterion("doctor_tel like", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelNotLike(String value) {
            addCriterion("doctor_tel not like", value, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelIn(List<String> values) {
            addCriterion("doctor_tel in", values, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelNotIn(List<String> values) {
            addCriterion("doctor_tel not in", values, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelBetween(String value1, String value2) {
            addCriterion("doctor_tel between", value1, value2, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andDoctorTelNotBetween(String value1, String value2) {
            addCriterion("doctor_tel not between", value1, value2, "doctorTel");
            return (Criteria) this;
        }

        public Criteria andHoBudgetIsNull() {
            addCriterion("ho_budget is null");
            return (Criteria) this;
        }

        public Criteria andHoBudgetIsNotNull() {
            addCriterion("ho_budget is not null");
            return (Criteria) this;
        }

        public Criteria andHoBudgetEqualTo(BigDecimal value) {
            addCriterion("ho_budget =", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetNotEqualTo(BigDecimal value) {
            addCriterion("ho_budget <>", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetGreaterThan(BigDecimal value) {
            addCriterion("ho_budget >", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ho_budget >=", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetLessThan(BigDecimal value) {
            addCriterion("ho_budget <", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ho_budget <=", value, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetIn(List<BigDecimal> values) {
            addCriterion("ho_budget in", values, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetNotIn(List<BigDecimal> values) {
            addCriterion("ho_budget not in", values, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ho_budget between", value1, value2, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andHoBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ho_budget not between", value1, value2, "hoBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetIsNull() {
            addCriterion("pe_budget is null");
            return (Criteria) this;
        }

        public Criteria andPeBudgetIsNotNull() {
            addCriterion("pe_budget is not null");
            return (Criteria) this;
        }

        public Criteria andPeBudgetEqualTo(BigDecimal value) {
            addCriterion("pe_budget =", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetNotEqualTo(BigDecimal value) {
            addCriterion("pe_budget <>", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetGreaterThan(BigDecimal value) {
            addCriterion("pe_budget >", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pe_budget >=", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetLessThan(BigDecimal value) {
            addCriterion("pe_budget <", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pe_budget <=", value, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetIn(List<BigDecimal> values) {
            addCriterion("pe_budget in", values, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetNotIn(List<BigDecimal> values) {
            addCriterion("pe_budget not in", values, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pe_budget between", value1, value2, "peBudget");
            return (Criteria) this;
        }

        public Criteria andPeBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pe_budget not between", value1, value2, "peBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetIsNull() {
            addCriterion("apply_budget is null");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetIsNotNull() {
            addCriterion("apply_budget is not null");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetEqualTo(BigDecimal value) {
            addCriterion("apply_budget =", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetNotEqualTo(BigDecimal value) {
            addCriterion("apply_budget <>", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetGreaterThan(BigDecimal value) {
            addCriterion("apply_budget >", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_budget >=", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetLessThan(BigDecimal value) {
            addCriterion("apply_budget <", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_budget <=", value, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetIn(List<BigDecimal> values) {
            addCriterion("apply_budget in", values, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetNotIn(List<BigDecimal> values) {
            addCriterion("apply_budget not in", values, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_budget between", value1, value2, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andApplyBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_budget not between", value1, value2, "applyBudget");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(Date value) {
            addCriterionForJDBCDate("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(Date value) {
            addCriterionForJDBCDate("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(Date value) {
            addCriterionForJDBCDate("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<Date> values) {
            addCriterionForJDBCDate("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioIsNull() {
            addCriterion("reimbursement_ratio is null");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioIsNotNull() {
            addCriterion("reimbursement_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioEqualTo(Double value) {
            addCriterion("reimbursement_ratio =", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioNotEqualTo(Double value) {
            addCriterion("reimbursement_ratio <>", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioGreaterThan(Double value) {
            addCriterion("reimbursement_ratio >", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioGreaterThanOrEqualTo(Double value) {
            addCriterion("reimbursement_ratio >=", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioLessThan(Double value) {
            addCriterion("reimbursement_ratio <", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioLessThanOrEqualTo(Double value) {
            addCriterion("reimbursement_ratio <=", value, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioIn(List<Double> values) {
            addCriterion("reimbursement_ratio in", values, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioNotIn(List<Double> values) {
            addCriterion("reimbursement_ratio not in", values, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioBetween(Double value1, Double value2) {
            addCriterion("reimbursement_ratio between", value1, value2, "reimbursementRatio");
            return (Criteria) this;
        }

        public Criteria andReimbursementRatioNotBetween(Double value1, Double value2) {
            addCriterion("reimbursement_ratio not between", value1, value2, "reimbursementRatio");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameIsNull() {
            addCriterion("apply_username is null");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameIsNotNull() {
            addCriterion("apply_username is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameEqualTo(String value) {
            addCriterion("apply_username =", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameNotEqualTo(String value) {
            addCriterion("apply_username <>", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameGreaterThan(String value) {
            addCriterion("apply_username >", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_username >=", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameLessThan(String value) {
            addCriterion("apply_username <", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameLessThanOrEqualTo(String value) {
            addCriterion("apply_username <=", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameLike(String value) {
            addCriterion("apply_username like", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameNotLike(String value) {
            addCriterion("apply_username not like", value, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameIn(List<String> values) {
            addCriterion("apply_username in", values, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameNotIn(List<String> values) {
            addCriterion("apply_username not in", values, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameBetween(String value1, String value2) {
            addCriterion("apply_username between", value1, value2, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyUsernameNotBetween(String value1, String value2) {
            addCriterion("apply_username not between", value1, value2, "applyUsername");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterionForJDBCDate("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_date not between", value1, value2, "applyDate");
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