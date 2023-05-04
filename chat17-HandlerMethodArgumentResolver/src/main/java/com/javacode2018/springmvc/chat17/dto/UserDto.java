package com.javacode2018.springmvc.chat17.dto;

/**
 * 用户
 */
public class UserDto {
    private String name;
    private PetDto pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetDto getPet() {
        return pet;
    }

    public void setPet(PetDto pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
