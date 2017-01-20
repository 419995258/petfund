package com.wdkj.xyfund.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PostulantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostulantExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(Integer value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(Integer value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(Integer value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(Integer value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<Integer> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<Integer> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(Integer value1, Integer value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("id_type not between", value1, value2, "idType");
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

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andZzmmIsNull() {
            addCriterion("zzmm is null");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNotNull() {
            addCriterion("zzmm is not null");
            return (Criteria) this;
        }

        public Criteria andZzmmEqualTo(String value) {
            addCriterion("zzmm =", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotEqualTo(String value) {
            addCriterion("zzmm <>", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThan(String value) {
            addCriterion("zzmm >", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThanOrEqualTo(String value) {
            addCriterion("zzmm >=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThan(String value) {
            addCriterion("zzmm <", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThanOrEqualTo(String value) {
            addCriterion("zzmm <=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLike(String value) {
            addCriterion("zzmm like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotLike(String value) {
            addCriterion("zzmm not like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmIn(List<String> values) {
            addCriterion("zzmm in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotIn(List<String> values) {
            addCriterion("zzmm not in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmBetween(String value1, String value2) {
            addCriterion("zzmm between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotBetween(String value1, String value2) {
            addCriterion("zzmm not between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeIsNull() {
            addCriterion("profession_type is null");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeIsNotNull() {
            addCriterion("profession_type is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeEqualTo(String value) {
            addCriterion("profession_type =", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeNotEqualTo(String value) {
            addCriterion("profession_type <>", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeGreaterThan(String value) {
            addCriterion("profession_type >", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("profession_type >=", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeLessThan(String value) {
            addCriterion("profession_type <", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeLessThanOrEqualTo(String value) {
            addCriterion("profession_type <=", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeLike(String value) {
            addCriterion("profession_type like", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeNotLike(String value) {
            addCriterion("profession_type not like", value, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeIn(List<String> values) {
            addCriterion("profession_type in", values, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeNotIn(List<String> values) {
            addCriterion("profession_type not in", values, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeBetween(String value1, String value2) {
            addCriterion("profession_type between", value1, value2, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionTypeNotBetween(String value1, String value2) {
            addCriterion("profession_type not between", value1, value2, "professionType");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andCLanguageIsNull() {
            addCriterion("c_language is null");
            return (Criteria) this;
        }

        public Criteria andCLanguageIsNotNull() {
            addCriterion("c_language is not null");
            return (Criteria) this;
        }

        public Criteria andCLanguageEqualTo(String value) {
            addCriterion("c_language =", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageNotEqualTo(String value) {
            addCriterion("c_language <>", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageGreaterThan(String value) {
            addCriterion("c_language >", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("c_language >=", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageLessThan(String value) {
            addCriterion("c_language <", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageLessThanOrEqualTo(String value) {
            addCriterion("c_language <=", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageLike(String value) {
            addCriterion("c_language like", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageNotLike(String value) {
            addCriterion("c_language not like", value, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageIn(List<String> values) {
            addCriterion("c_language in", values, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageNotIn(List<String> values) {
            addCriterion("c_language not in", values, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageBetween(String value1, String value2) {
            addCriterion("c_language between", value1, value2, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andCLanguageNotBetween(String value1, String value2) {
            addCriterion("c_language not between", value1, value2, "cLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageIsNull() {
            addCriterion("e_language is null");
            return (Criteria) this;
        }

        public Criteria andELanguageIsNotNull() {
            addCriterion("e_language is not null");
            return (Criteria) this;
        }

        public Criteria andELanguageEqualTo(String value) {
            addCriterion("e_language =", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageNotEqualTo(String value) {
            addCriterion("e_language <>", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageGreaterThan(String value) {
            addCriterion("e_language >", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageGreaterThanOrEqualTo(String value) {
            addCriterion("e_language >=", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageLessThan(String value) {
            addCriterion("e_language <", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageLessThanOrEqualTo(String value) {
            addCriterion("e_language <=", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageLike(String value) {
            addCriterion("e_language like", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageNotLike(String value) {
            addCriterion("e_language not like", value, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageIn(List<String> values) {
            addCriterion("e_language in", values, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageNotIn(List<String> values) {
            addCriterion("e_language not in", values, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageBetween(String value1, String value2) {
            addCriterion("e_language between", value1, value2, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageNotBetween(String value1, String value2) {
            addCriterion("e_language not between", value1, value2, "eLanguage");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelIsNull() {
            addCriterion("e_language_level is null");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelIsNotNull() {
            addCriterion("e_language_level is not null");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelEqualTo(String value) {
            addCriterion("e_language_level =", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelNotEqualTo(String value) {
            addCriterion("e_language_level <>", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelGreaterThan(String value) {
            addCriterion("e_language_level >", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelGreaterThanOrEqualTo(String value) {
            addCriterion("e_language_level >=", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelLessThan(String value) {
            addCriterion("e_language_level <", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelLessThanOrEqualTo(String value) {
            addCriterion("e_language_level <=", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelLike(String value) {
            addCriterion("e_language_level like", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelNotLike(String value) {
            addCriterion("e_language_level not like", value, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelIn(List<String> values) {
            addCriterion("e_language_level in", values, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelNotIn(List<String> values) {
            addCriterion("e_language_level not in", values, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelBetween(String value1, String value2) {
            addCriterion("e_language_level between", value1, value2, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andELanguageLevelNotBetween(String value1, String value2) {
            addCriterion("e_language_level not between", value1, value2, "eLanguageLevel");
            return (Criteria) this;
        }

        public Criteria andBloodGroupIsNull() {
            addCriterion("blood_group is null");
            return (Criteria) this;
        }

        public Criteria andBloodGroupIsNotNull() {
            addCriterion("blood_group is not null");
            return (Criteria) this;
        }

        public Criteria andBloodGroupEqualTo(Integer value) {
            addCriterion("blood_group =", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupNotEqualTo(Integer value) {
            addCriterion("blood_group <>", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupGreaterThan(Integer value) {
            addCriterion("blood_group >", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("blood_group >=", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupLessThan(Integer value) {
            addCriterion("blood_group <", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupLessThanOrEqualTo(Integer value) {
            addCriterion("blood_group <=", value, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupIn(List<Integer> values) {
            addCriterion("blood_group in", values, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupNotIn(List<Integer> values) {
            addCriterion("blood_group not in", values, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupBetween(Integer value1, Integer value2) {
            addCriterion("blood_group between", value1, value2, "bloodGroup");
            return (Criteria) this;
        }

        public Criteria andBloodGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("blood_group not between", value1, value2, "bloodGroup");
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

        public Criteria andZoneIsNull() {
            addCriterion("zone is null");
            return (Criteria) this;
        }

        public Criteria andZoneIsNotNull() {
            addCriterion("zone is not null");
            return (Criteria) this;
        }

        public Criteria andZoneEqualTo(String value) {
            addCriterion("zone =", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotEqualTo(String value) {
            addCriterion("zone <>", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThan(String value) {
            addCriterion("zone >", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThanOrEqualTo(String value) {
            addCriterion("zone >=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThan(String value) {
            addCriterion("zone <", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThanOrEqualTo(String value) {
            addCriterion("zone <=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLike(String value) {
            addCriterion("zone like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotLike(String value) {
            addCriterion("zone not like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneIn(List<String> values) {
            addCriterion("zone in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotIn(List<String> values) {
            addCriterion("zone not in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneBetween(String value1, String value2) {
            addCriterion("zone between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotBetween(String value1, String value2) {
            addCriterion("zone not between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andOtherTelIsNull() {
            addCriterion("other_tel is null");
            return (Criteria) this;
        }

        public Criteria andOtherTelIsNotNull() {
            addCriterion("other_tel is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTelEqualTo(String value) {
            addCriterion("other_tel =", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelNotEqualTo(String value) {
            addCriterion("other_tel <>", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelGreaterThan(String value) {
            addCriterion("other_tel >", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelGreaterThanOrEqualTo(String value) {
            addCriterion("other_tel >=", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelLessThan(String value) {
            addCriterion("other_tel <", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelLessThanOrEqualTo(String value) {
            addCriterion("other_tel <=", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelLike(String value) {
            addCriterion("other_tel like", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelNotLike(String value) {
            addCriterion("other_tel not like", value, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelIn(List<String> values) {
            addCriterion("other_tel in", values, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelNotIn(List<String> values) {
            addCriterion("other_tel not in", values, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelBetween(String value1, String value2) {
            addCriterion("other_tel between", value1, value2, "otherTel");
            return (Criteria) this;
        }

        public Criteria andOtherTelNotBetween(String value1, String value2) {
            addCriterion("other_tel not between", value1, value2, "otherTel");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeIsNull() {
            addCriterion("unit_trade_type is null");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeIsNotNull() {
            addCriterion("unit_trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeEqualTo(String value) {
            addCriterion("unit_trade_type =", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeNotEqualTo(String value) {
            addCriterion("unit_trade_type <>", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeGreaterThan(String value) {
            addCriterion("unit_trade_type >", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_trade_type >=", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeLessThan(String value) {
            addCriterion("unit_trade_type <", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("unit_trade_type <=", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeLike(String value) {
            addCriterion("unit_trade_type like", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeNotLike(String value) {
            addCriterion("unit_trade_type not like", value, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeIn(List<String> values) {
            addCriterion("unit_trade_type in", values, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeNotIn(List<String> values) {
            addCriterion("unit_trade_type not in", values, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeBetween(String value1, String value2) {
            addCriterion("unit_trade_type between", value1, value2, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTradeTypeNotBetween(String value1, String value2) {
            addCriterion("unit_trade_type not between", value1, value2, "unitTradeType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNull() {
            addCriterion("unit_type is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("unit_type =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("unit_type <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("unit_type >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_type >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("unit_type <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("unit_type <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("unit_type like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("unit_type not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("unit_type in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("unit_type not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("unit_type between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("unit_type not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIsNull() {
            addCriterion("service_area is null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIsNotNull() {
            addCriterion("service_area is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaEqualTo(String value) {
            addCriterion("service_area =", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotEqualTo(String value) {
            addCriterion("service_area <>", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaGreaterThan(String value) {
            addCriterion("service_area >", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaGreaterThanOrEqualTo(String value) {
            addCriterion("service_area >=", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaLessThan(String value) {
            addCriterion("service_area <", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaLessThanOrEqualTo(String value) {
            addCriterion("service_area <=", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaLike(String value) {
            addCriterion("service_area like", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotLike(String value) {
            addCriterion("service_area not like", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIn(List<String> values) {
            addCriterion("service_area in", values, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotIn(List<String> values) {
            addCriterion("service_area not in", values, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaBetween(String value1, String value2) {
            addCriterion("service_area between", value1, value2, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotBetween(String value1, String value2) {
            addCriterion("service_area not between", value1, value2, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIsNull() {
            addCriterion("service_object is null");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIsNotNull() {
            addCriterion("service_object is not null");
            return (Criteria) this;
        }

        public Criteria andServiceObjectEqualTo(String value) {
            addCriterion("service_object =", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectNotEqualTo(String value) {
            addCriterion("service_object <>", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectGreaterThan(String value) {
            addCriterion("service_object >", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectGreaterThanOrEqualTo(String value) {
            addCriterion("service_object >=", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectLessThan(String value) {
            addCriterion("service_object <", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectLessThanOrEqualTo(String value) {
            addCriterion("service_object <=", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectLike(String value) {
            addCriterion("service_object like", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectNotLike(String value) {
            addCriterion("service_object not like", value, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIn(List<String> values) {
            addCriterion("service_object in", values, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectNotIn(List<String> values) {
            addCriterion("service_object not in", values, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectBetween(String value1, String value2) {
            addCriterion("service_object between", value1, value2, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andServiceObjectNotBetween(String value1, String value2) {
            addCriterion("service_object not between", value1, value2, "serviceObject");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateIsNull() {
            addCriterion("is_service_date is null");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateIsNotNull() {
            addCriterion("is_service_date is not null");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateEqualTo(Date value) {
            addCriterionForJDBCDate("is_service_date =", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("is_service_date <>", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("is_service_date >", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("is_service_date >=", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateLessThan(Date value) {
            addCriterionForJDBCDate("is_service_date <", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("is_service_date <=", value, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateIn(List<Date> values) {
            addCriterionForJDBCDate("is_service_date in", values, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("is_service_date not in", values, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("is_service_date between", value1, value2, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andIsServiceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("is_service_date not between", value1, value2, "isServiceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNull() {
            addCriterion("service_date is null");
            return (Criteria) this;
        }

        public Criteria andServiceDateIsNotNull() {
            addCriterion("service_date is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDateEqualTo(Date value) {
            addCriterionForJDBCDate("service_date =", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("service_date <>", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("service_date >", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_date >=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThan(Date value) {
            addCriterionForJDBCDate("service_date <", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("service_date <=", value, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateIn(List<Date> values) {
            addCriterionForJDBCDate("service_date in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("service_date not in", values, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_date between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andServiceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("service_date not between", value1, value2, "serviceDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNull() {
            addCriterion("training_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNotNull() {
            addCriterion("training_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateEqualTo(Date value) {
            addCriterionForJDBCDate("training_date =", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("training_date <>", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThan(Date value) {
            addCriterionForJDBCDate("training_date >", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("training_date >=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThan(Date value) {
            addCriterionForJDBCDate("training_date <", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("training_date <=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIn(List<Date> values) {
            addCriterionForJDBCDate("training_date in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("training_date not in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("training_date between", value1, value2, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("training_date not between", value1, value2, "trainingDate");
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