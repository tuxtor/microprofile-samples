package com.vorozco;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simple")
@RolesAllowed({"simpleuser"})
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
public class SimpleUserController {

    @GET
    public String getInfo(){
        return "Eres un usuario simple :)";
    }
}
