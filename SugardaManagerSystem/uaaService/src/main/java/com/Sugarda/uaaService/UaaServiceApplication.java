package com.Sugarda.uaaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableEurekaClient
@SpringBootApplication
@EnableAuthorizationServer
public class UaaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }
}
