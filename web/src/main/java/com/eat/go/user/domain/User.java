package com.eat.go.user.domain;

import com.eat.go.common.Identifiable;
import com.eat.go.pet.domain.Pet;
import com.eat.go.timeTable.domain.TimeTable;

import javax.persistence.*;
import java.util.Set;


/**
 * @author Nik Smirnov
 */
@Entity
@Table(name = "user")
public class User extends Identifiable {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Pet> pets;

    @OneToMany(mappedBy = "user")
    private Set<TimeTable> timeTables;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(Set<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }
}
