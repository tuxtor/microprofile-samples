package com.vorozco.demo.jsonb.controller;

import com.vorozco.demo.jsonb.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    List<Person> persons = new ArrayList<>();

    @GET
    public List<Person> listAll(){
        return persons;
    }

    @POST
    public Response createPerson(Person person, @Context UriInfo uriInfo){
        person.setPersonId(persons.size() + 1L);
        persons.add(person);
        URI uri = uriInfo.getAbsolutePathBuilder().path(person.getPersonId().toString()).build();
        return Response.created(uri).build();
    }

    @GET
    @Path("/from-json")
    public String fromJsontoJava(){
        String persona = """
                {
                    "age": 200,
                    "birthday": "15.09.1821",
                    "name": "Guatemala",
                    "nick": "Guatebala"
                }
                """;

        var jsonbuilder = JsonbBuilder.create();
        var person = jsonbuilder.fromJson(persona, Person.class);

        return "El nombre de la persona es " + person.getName();
    }

    @GET
    @Path("/to-json")
    public String fromJavatoJson(){
        var person = new Person(99L, "Francisco Panthera Onca", 22, LocalDate.now(), "Pancho Pantera");


        var jsonconfig = new JsonbConfig()
                .withFormatting(true)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
        var jsonbuilder = JsonbBuilder.create(jsonconfig);

        var personJson = jsonbuilder.toJson(person);

        return personJson;
    }
}
