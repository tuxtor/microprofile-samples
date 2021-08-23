package com.vorozco;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"simpleuser", "poweruser"})
    public String hello(@Context SecurityContext ctx) {
        return "Hola " + ctx.getUserPrincipal().getName() + " token proveido por " + jwt.getIssuer();
    }
}
