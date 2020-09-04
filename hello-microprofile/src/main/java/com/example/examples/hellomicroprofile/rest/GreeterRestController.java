package com.example.examples.hellomicroprofile.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.example.examples.hellomicroprofile.dto.BackendDTO;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api")
public class GreeterRestController {
    
    @Inject
    @ConfigProperty(name = "greeting.saying", defaultValue = "Hello")
    private String saying;

    @Inject
    @ConfigProperty(name = "greeting.backendHost", defaultValue = "localhost")
    private String backendHost;

    @Inject
    @ConfigProperty(name = "greeting.backendPort", defaultValue = "3000")
    private String backendPort;

    @GET
    @Path("/greeting")
    @Produces("text/plain")
    public String greeting() {
        String url = String.format("http://%s:%s", backendHost, backendPort);

        Client client = ClientBuilder.newClient();
        
        BackendDTO dto = client.target(url)
            .path("api")
            .path("backend")
            .queryParam("greeting", saying)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get(BackendDTO.class);
        
        return dto.getGreeting() + " at host: " + dto.getIp();
    }

}
