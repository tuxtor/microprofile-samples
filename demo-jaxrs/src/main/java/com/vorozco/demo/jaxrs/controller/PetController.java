package com.vorozco.demo.jaxrs.controller;

import com.vorozco.demo.jaxrs.model.Pet;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/pets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class PetController {

    Map<Long, Pet> petMap = new HashMap<>();

    @GET
    public List<Pet> listAll() {
        return new ArrayList<>(this.petMap.values());
    }

    @GET
    @Path("/{id: [0-9]+}")
    public Pet findById(@PathParam("id") Long petId){
        return petMap.get(petId);
    }

    @POST
    public Response createPet(Pet pet){
        if(pet.getPetId() == null){
            pet = new Pet(this.petMap.size() + 1L, pet.getName(), pet.getAnimal());
        }
        this.petMap.put(pet.getPetId(), pet);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }

    @PUT
    @Path("/{id: [0-9]+}")
    public Response updatePet(@PathParam("id") Long petId, Pet pet){
        if(!petId.equals(pet.getPetId()) || !this.petMap.containsKey(petId)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.petMap.put(pet.getPetId(), pet);
        return Response
                .accepted()
                .build();
    }

    @DELETE
    @Path("/{id: [0-9]+}")
    public Response deletePet(@PathParam("id") Long petId){
        if(!this.petMap.containsKey(petId)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.petMap.remove(petId);
        return Response
                .ok()
                .build();
    }
}
