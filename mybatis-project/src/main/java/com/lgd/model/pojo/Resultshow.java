package com.lgd.model.pojo;

public class Resultshow {
    private String time;

    private Integer roadgatenode;

    private Integer monitornode;

    private Integer alarmnode;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getRoadgatenode() {
        return roadgatenode;
    }

    public void setRoadgatenode(Integer roadgatenode) {
        this.roadgatenode = roadgatenode;
    }

    public Integer getMonitornode() {
        return monitornode;
    }

    public void setMonitornode(Integer monitornode) {
        this.monitornode = monitornode;
    }

    public Integer getAlarmnode() {
        return alarmnode;
    }

    public void setAlarmnode(Integer alarmnode) {
        this.alarmnode = alarmnode;
    }
}