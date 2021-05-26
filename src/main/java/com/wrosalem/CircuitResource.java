package com.wrosalem;

import java.time.temporal.ChronoUnit;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/circuit")
public class CircuitResource {
    
    //Essa notação Especificação do MicroProfile, vem com a API de Fault Tolerance
    @Timeout(unit = ChronoUnit.MILLIS, value = 500)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold=4,
        failureRatio=0.5,
        delay = 2000,
        successThreshold=2
    )


    @GET
    public String getCircuit() throws InterruptedException{
        Thread.sleep(600);
        return "Circuit \n";
    }

    private String fallback(){
        return "Sou um fallback\n";
    }
}
