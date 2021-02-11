package com.vorozco.repository;

import com.vorozco.model.Person;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
@Path("/api")
public interface SwapiClient {

    @GET
    @Path("/people/{personId}/")
    @Produces(MediaType.APPLICATION_JSON)
    Person getPerson(@PathParam("personId") Integer personId);
}
