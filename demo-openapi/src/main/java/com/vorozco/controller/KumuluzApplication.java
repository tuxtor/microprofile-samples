package com.vorozco.controller;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
//@OpenAPIDefinition(info = @Info(title = "KumuluzApi", version = "v1.0.0", contact = @Contact(email = "me@vorozco.com", name = "Victor Orozco"), license = @License(name="MIT")))
public class KumuluzApplication extends Application {
}
