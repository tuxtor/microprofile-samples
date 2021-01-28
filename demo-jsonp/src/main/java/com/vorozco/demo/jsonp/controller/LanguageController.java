package com.vorozco.demo.jsonp.controller;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPatch;
import javax.json.JsonPointer;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;

@Path("/languages")
@Produces(MediaType.APPLICATION_JSON)
public class LanguageController {

    @GET
    @Path("/java")
    public String getJavaPower(){
        JsonObject javaJson = Json.createObjectBuilder()
                .add("name", "Java")
                .add("age", 25)
                .add("envs",
                        Json.createArrayBuilder()
                        .add("HotSpot")
                        .add("GraalVM")
                        .add("OpenJ9"))
                .add("creator",
                        Json.createObjectBuilder()
                        .add("name", "James Gossling")
                        .add("country", "Canada")
                )
                .build();

        return javaJson.toString();
    }

    @POST
    @Path("/creator")
    public String processCreator(String originalJson){
        JsonObject jsonObject = Json.createReader(new StringReader(originalJson)).readObject();
        JsonObject creator = jsonObject.getJsonObject("creator");
        return "El creador de acuerdo a la info es " + creator.getString("name");
    }

    @POST
    @Path("/manipulate")
    public String manipulateJson(String originalJson){
        JsonObject jsonObject = Json.createReader(new StringReader(originalJson)).readObject();

        JsonPointer namePointer = Json.createPointer("/name");
        JsonPointer createNamePointer = Json.createPointer("/creator/name");

        jsonObject = namePointer.replace(jsonObject, Json.createValue("C#"));
        jsonObject = Json.createPointer("/age").replace(jsonObject, Json.createValue(15));
        jsonObject = createNamePointer.replace(jsonObject, Json.createValue("Anders Hejlsberg"));
        jsonObject = Json.createPointer("/envs")
                .replace(jsonObject, Json.createArrayBuilder().add(".net Framework").add(".net core").build());

        return jsonObject.toString();
    }

    @POST
    @Path("/patch")
    public String patchJson(String originalJson){
        JsonObject jsonObject = Json.createReader(new StringReader(originalJson)).readObject();

        JsonPatch patch = Json.createPatchBuilder()
                .replace("/name", "C Sharp")
                .replace("/age", 15)
                .replace("/creator/name", "Anders Hejlsberg")
                .replace("/envs", Json.createArrayBuilder().add(".net Framework").add(".net core").build())
                .build();

        jsonObject = patch.apply(jsonObject);
        return jsonObject.toString();
    }

}
