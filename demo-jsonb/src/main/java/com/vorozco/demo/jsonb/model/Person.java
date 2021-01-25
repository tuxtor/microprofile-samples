package com.vorozco.demo.jsonb.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

public class Person {

    private Long personId;
    private String name;
    private Integer age;
    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate birthday;

    @JsonbProperty("nick")
    private String nickname;


    public Person() {
    }

    public Person(Long personId, String name, Integer age, LocalDate birthday, String nickname) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
