package com.vorozco;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("demo-config")
public class DemoResource {

    @Inject
    @ConfigProperty(name = "demo", defaultValue = "valor predeterminado")
    String demoConfig;

    @GET
    public String getDemoInfo(){
        return "Informacion: " + demoConfig;
    }
}
