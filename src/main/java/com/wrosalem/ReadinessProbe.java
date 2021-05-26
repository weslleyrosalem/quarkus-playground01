package com.wrosalem;

import javax.ws.rs.client.ClientBuilder;

import com.twitter.zipkin.thriftjava.Response;
import com.twitter.zipkin.thriftjava.ZipkinCollector.Client;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessProbe implements HealthCheck{

    @Override
    public HealthCheckResponse call() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        javax.ws.rs.core.Response response = client.target("https://www.google.com/").request().get();

        if (response.getStatus() == 200){
            return HealthCheckResponse.up("Estou Pronto");
        }else{
            return HealthCheckResponse.down("Estou Down");
        }
    }
    
}
