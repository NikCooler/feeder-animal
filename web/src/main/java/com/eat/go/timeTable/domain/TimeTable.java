package com.eat.go.timeTable.domain;

import com.eat.go.common.Identifiable;
import com.eat.go.user.domain.User;

import javax.persistence.*;
import java.util.Date;


/**
 * @author Nik Smirnov
 */
@Entity
@Table(name = "timetable")
public class TimeTable extends Identifiable {

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "time")
    private Date time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
