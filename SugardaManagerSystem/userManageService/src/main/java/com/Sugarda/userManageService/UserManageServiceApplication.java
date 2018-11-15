package com.Sugarda.userManageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class UserManageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManageServiceApplication.class, args);
    }

    @GetMapping(value = "/test")
    public String hello() {
        return "hello world";
    }
}
