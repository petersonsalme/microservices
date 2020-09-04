package com.redhat.examples.hellospringboot;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.redhat.examples.dto.BackendDTO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "greeting")
public class GreeterRestController {

    private RestTemplate restTemplate = new RestTemplate();

    private String saying;
    private String backendHost;
    private String backendPort;

    @RequestMapping(method = GET, value = "/greeting", produces = TEXT_PLAIN_VALUE)
    public String greeting() {
        String url = "http://%s:%s/api/backend?greeting={greeting}";
        String backendUrl = String.format(url, backendHost, backendPort);

        BackendDTO dto = restTemplate.getForObject(backendUrl, BackendDTO.class, saying);

        return dto.getGreeting() + " at host: " + dto.getIp();
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public void setBackendHost(String backendHost) {
        this.backendHost = backendHost;
    }

    public void setBackendPort(String backendPort) {
        this.backendPort = backendPort;
    }

}
