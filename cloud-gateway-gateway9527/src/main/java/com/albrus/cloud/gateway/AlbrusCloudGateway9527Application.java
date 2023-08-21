package com.albrus.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AlbrusCloudGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudGateway9527Application.class, args);
    }

}
