package com.Sugarda.userManageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
//public class UserManageServiceApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(UserManageServiceApplication.class, args);
//    }
//}
public class UserManageServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserManageServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(UserManageServiceApplication.class);
    }
}
