package com.vorozco.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Person", description = "Person DTO")
public class Person {

    @Schema
    private Long personId;
    @Schema(required = true, example = "El name")
    private String name;
    @Schema
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
