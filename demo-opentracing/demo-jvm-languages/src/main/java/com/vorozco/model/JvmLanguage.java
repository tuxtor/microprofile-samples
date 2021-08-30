package com.vorozco.model;

public class JvmLanguage {

    private String name;
    private Integer year;

    public JvmLanguage() {
    }

    public JvmLanguage(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
