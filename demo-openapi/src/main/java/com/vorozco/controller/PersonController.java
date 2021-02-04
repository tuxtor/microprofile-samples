package com.vorozco.controller;

import com.vorozco.model.Person;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
public class PersonController {

    List<Person> personsList = new ArrayList<>();

    @GET
    @Operation(summary = "Returns the list of users", description = "Using a volatile list, it returns the complete list of users with no filters")
    public List<Person> getPersons(){
        return personsList;
    }

    @GET
    @Path("/{personId}")
    @Operation(summary = "Returns a particular user")
    @APIResponse(description = "The person",
        content = @Content(mediaType = MediaType.APPLICATION_JSON,
        schema = @Schema(implementation = Person.class))
    )
    @APIResponse(responseCode = "404", description = "Person not found")
    public Response findPersonById(@PathParam("personId") Integer personId){
        if(personId > personsList.size()-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            return Response.ok(this.personsList.get(personId)).build();
        }
    }

    @POST
    public void createPerson(Person person){
        this.personsList.add(person);
    }
}
