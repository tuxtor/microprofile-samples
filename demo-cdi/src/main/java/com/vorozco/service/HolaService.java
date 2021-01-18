package com.vorozco.service;

import jdk.jfr.Name;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Singleton;

@Dependent
@Named("es-GT")
public class HolaService implements GreetingService {

    @PostConstruct
    public void init(){
        System.out.println("Arrancando el servidor");
    }

    public String doHello(String name) {
        return "Hola " + name;
    }
}
