package com.vorozco.client;

import com.vorozco.model.JvmLanguage;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RegisterRestClient(baseUri = "http://demo-jvm-languages:8080")
@Path("/jvm-languages")
public interface JvmLanguageClient {

    @GET
    public List<JvmLanguage> getJvmLanguageList();

}
