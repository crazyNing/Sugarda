package com.Sugarda.userManageService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class UserManageServiceApplication {
    @GetMapping(value = "/test")
    public String test(){
        return "testtest";
    }
    public static void main(String[] args) {
        SpringApplication.run(UserManageServiceApplication.class, args);
    }
}
