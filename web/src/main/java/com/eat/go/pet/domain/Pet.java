package com.eat.go.pet.domain;

import com.eat.go.common.Identifiable;
import com.eat.go.pet.dict.PetType;

import javax.persistence.*;


/**
 * @author Nik Smirnov
 */
@Entity
@Table(name = "pet")
public class Pet extends Identifiable {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "age")
    private String age;

    @Column(name = "pet_type")
    @Enumerated(EnumType.STRING)
    private PetType pet_type;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public PetType getPet_type() {
        return pet_type;
    }

    public void setPet_type(PetType pet_type) {
        this.pet_type = pet_type;
    }
}
