package com.lgd.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResultshowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultshowExample() {
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

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeIsNull() {
            addCriterion("roadgateNode is null");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeIsNotNull() {
            addCriterion("roadgateNode is not null");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeEqualTo(Integer value) {
            addCriterion("roadgateNode =", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeNotEqualTo(Integer value) {
            addCriterion("roadgateNode <>", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeGreaterThan(Integer value) {
            addCriterion("roadgateNode >", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("roadgateNode >=", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeLessThan(Integer value) {
            addCriterion("roadgateNode <", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeLessThanOrEqualTo(Integer value) {
            addCriterion("roadgateNode <=", value, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeIn(List<Integer> values) {
            addCriterion("roadgateNode in", values, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeNotIn(List<Integer> values) {
            addCriterion("roadgateNode not in", values, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeBetween(Integer value1, Integer value2) {
            addCriterion("roadgateNode between", value1, value2, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andRoadgatenodeNotBetween(Integer value1, Integer value2) {
            addCriterion("roadgateNode not between", value1, value2, "roadgatenode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeIsNull() {
            addCriterion("monitorNode is null");
            return (Criteria) this;
        }

        public Criteria andMonitornodeIsNotNull() {
            addCriterion("monitorNode is not null");
            return (Criteria) this;
        }

        public Criteria andMonitornodeEqualTo(Integer value) {
            addCriterion("monitorNode =", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeNotEqualTo(Integer value) {
            addCriterion("monitorNode <>", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeGreaterThan(Integer value) {
            addCriterion("monitorNode >", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("monitorNode >=", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeLessThan(Integer value) {
            addCriterion("monitorNode <", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeLessThanOrEqualTo(Integer value) {
            addCriterion("monitorNode <=", value, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeIn(List<Integer> values) {
            addCriterion("monitorNode in", values, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeNotIn(List<Integer> values) {
            addCriterion("monitorNode not in", values, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeBetween(Integer value1, Integer value2) {
            addCriterion("monitorNode between", value1, value2, "monitornode");
            return (Criteria) this;
        }

        public Criteria andMonitornodeNotBetween(Integer value1, Integer value2) {
            addCriterion("monitorNode not between", value1, value2, "monitornode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeIsNull() {
            addCriterion("alarmNode is null");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeIsNotNull() {
            addCriterion("alarmNode is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeEqualTo(Integer value) {
            addCriterion("alarmNode =", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeNotEqualTo(Integer value) {
            addCriterion("alarmNode <>", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeGreaterThan(Integer value) {
            addCriterion("alarmNode >", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarmNode >=", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeLessThan(Integer value) {
            addCriterion("alarmNode <", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeLessThanOrEqualTo(Integer value) {
            addCriterion("alarmNode <=", value, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeIn(List<Integer> values) {
            addCriterion("alarmNode in", values, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeNotIn(List<Integer> values) {
            addCriterion("alarmNode not in", values, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeBetween(Integer value1, Integer value2) {
            addCriterion("alarmNode between", value1, value2, "alarmnode");
            return (Criteria) this;
        }

        public Criteria andAlarmnodeNotBetween(Integer value1, Integer value2) {
            addCriterion("alarmNode not between", value1, value2, "alarmnode");
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