package com.wrosalem;

import java.util.Optional;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.opentracing.Traced;

//Anotacao Traced  = tracing distribuido :) simples assim
@Traced
@Path("/config")
public class ConfigResource {
    
    @ConfigProperty(name = "config")
    Optional<String> config;

    @GET
    //@Produces(MediaType.TEXT_PLAIN)
    public String getconfig(){
        return "Olá, " + config.orElse("optional") + "\n";
    }
}
