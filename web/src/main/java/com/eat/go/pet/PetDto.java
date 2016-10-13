package com.eat.go.pet;

import com.eat.go.pet.dict.PetType;


public class PetDto {

    private String nickname;

    private String age;

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
