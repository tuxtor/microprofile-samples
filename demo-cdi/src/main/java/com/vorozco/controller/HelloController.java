package com.vorozco.controller;

import com.vorozco.service.GreetingService;
import com.vorozco.service.HelloService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.logging.Logger;

@Path("/hello")
public class HelloController {

    /*@Inject @Named("en-US")

     */
    GreetingService greetingService;
    Logger logger;

    @Inject
    public HelloController(@Named("en-US") GreetingService greetingService,
                           Logger logger){
        this.greetingService = greetingService;
        this.logger = logger;
    }

    @GET
    public String doHello(@QueryParam("name") @DefaultValue("unknown") String name){
        logger.warning("Creating a warning");
        return greetingService.doHello(name);
    }


}
