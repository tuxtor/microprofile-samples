package com.vorozco.controller;

import com.vorozco.client.JvmLanguageClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/demo")
public class DemoController {

    @Inject
    @RestClient
    JvmLanguageClient jvmLanguageClient;

    @GET
    public String doDemo(){
        return "La informacion obtenida dice que el lenguaje joven es " +
                jvmLanguageClient.getJvmLanguageList().stream()
                        .sorted((l1, l2) -> l2.getYear().compareTo(l1.getYear()))
                        .findFirst().get().getName();
    }

}
