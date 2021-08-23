package com.vorozco;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/power")
@RolesAllowed({"poweruser"})
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
public class PowerUserController {

    @GET
    public String getInfo(){
        return "Eres un usuario poderoso, bien campeon :)";
    }

    @GET
    @Path("/abierto")
    @PermitAll
    public String getRandomInfo(){
        return "Este es un método público, no hay token";
    }
}
