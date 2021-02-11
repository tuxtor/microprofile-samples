package com.vorozco.controller;

import com.vorozco.repository.SwapiClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("/demo")
@Singleton
public class DemoController {

    @Inject
    @RestClient
    SwapiClient swapiClient;

    @GET
    public String doDemo(@QueryParam("person-id") @DefaultValue("1") Integer personId)
            throws UnknownHostException {
        var person = swapiClient.getPerson(personId);
        var hostname = InetAddress.getLocalHost().getHostName();

        System.out.println(person);
        return "Respondiendo desde " + hostname + " encontré a la persona " + person.getName();
    }
}
