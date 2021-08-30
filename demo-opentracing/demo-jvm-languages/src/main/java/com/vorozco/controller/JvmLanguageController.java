package com.vorozco.controller;

import com.vorozco.model.JvmLanguage;
import com.vorozco.service.JvmLanguageService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/jvm-languages")
@Produces(MediaType.APPLICATION_JSON)
public class JvmLanguageController {

    private JvmLanguageService jvmLanguageService;

    @Inject
    public JvmLanguageController(JvmLanguageService jvmLanguageService){
        this.jvmLanguageService = jvmLanguageService;
    }

    @GET
    public List<JvmLanguage> getJvmLanguageList(){
        return this.jvmLanguageService.getJvmLanguageList();
    }

}
