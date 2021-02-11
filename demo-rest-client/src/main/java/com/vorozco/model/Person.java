package com.vorozco.model;

import javax.json.bind.annotation.JsonbProperty;

public class Person {

    private String name;

    @JsonbProperty("hair_color")
    private String hairColor;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
