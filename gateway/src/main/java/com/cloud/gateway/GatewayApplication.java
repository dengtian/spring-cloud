package com.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayApplication {

    @Value("${data}")
    private String routes;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @GetMapping("get")
    public Object get() {
        return routes;
    }
}
