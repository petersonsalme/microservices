package com.redhat.examples.hellospringboot;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.InetAddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "hello")
public class HelloRestController {

    private String saying;

    @RequestMapping(method = GET, value = "/hello", produces = TEXT_PLAIN_VALUE)
    public String hello() {
        String hostname = null;

        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            hostname = "Unknown";
        }

        return saying + " " + hostname;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

}
