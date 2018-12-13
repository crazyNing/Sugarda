package com.Sugarda.adminService;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
/**
 * 使用jar包运行语法 */
//public class AdminServiceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(AdminServiceApplication.class, args);
//	}
//}
/**
 * 使用war包运行写法
 */
public class AdminServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(AdminServiceApplication.class);
    }
}
