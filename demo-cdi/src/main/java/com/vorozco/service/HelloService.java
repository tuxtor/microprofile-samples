package com.vorozco.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Singleton;

@ApplicationScoped
@Named("en-US")
public class HelloService implements GreetingService {

    @PostConstruct
    public void init(){
        System.out.println("Starting service");
    }

    public String doHello(String name) {
        return "Hello " + name;
    }
}
