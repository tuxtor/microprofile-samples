package com.vorozco.demo.jaxrs.model;

public class Pet {
    private Long petId;
    private String name;
    private String animal;

    public Pet() {
    }

    public Pet(Long petId, String name, String animal) {
        this.petId = petId;
        this.name = name;
        this.animal = animal;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
