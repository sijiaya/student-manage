package com.sm.entity;

import java.util.Date;

public class RewardPunish {
    private Integer id ;
    private  String studentId;
    private String departmentName;
    private String className;
    private  String event;
    private  String stuName;
    private String rank;
    private Date rpDate;
    private Integer eventId;
    private Integer rankId;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getRpDate() {
        return rpDate;
    }

    public void setRpDate(Date rpDate) {
        this.rpDate = rpDate;
    }

//    @Override
//    public String toString() {
//        return "RewardPunish{" +
//                "id=" + id +
//                ", departmentName='" + departmentName + '\'' +
//                ", className='" + className + '\'' +
//                ", event='" + event + '\'' +
//                ", stuName='" + stuName + '\'' +
//                ", rank='" + rank + '\'' +
//                ", rpDate=" + rpDate +
//                '}';
//    }

    @Override
    public String toString() {
        return event;
    }


}
