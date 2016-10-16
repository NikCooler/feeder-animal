package com.eat.go.timeTable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class TimeTableDto {

    private Integer timeTableId;

    private Integer weight;

    private Long time;

    private Integer userId;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(Integer timeTableId) {
        this.timeTableId = timeTableId;
    }
}
