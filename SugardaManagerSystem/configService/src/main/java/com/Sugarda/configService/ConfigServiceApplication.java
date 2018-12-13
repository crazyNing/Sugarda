package com.Sugarda.configService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
//public class ConfigServiceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConfigServiceApplication.class, args);
//	}
//}
public class ConfigServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(ConfigServiceApplication.class);
    }
}
