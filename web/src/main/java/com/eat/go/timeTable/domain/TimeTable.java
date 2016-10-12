package com.eat.go.timeTable.domain;

import com.eat.go.common.Identifiable;

import javax.persistence.*;


@Entity
@Table(name = "pet")
public class TimeTable extends Identifiable {

    @Column(name = "event")
    private String event;

    @Column(name = "cron_expression")
    private String cronExpression;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
