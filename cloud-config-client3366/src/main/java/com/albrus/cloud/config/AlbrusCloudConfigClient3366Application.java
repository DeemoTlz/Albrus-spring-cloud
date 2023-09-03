package com.albrus.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AlbrusCloudConfigClient3366Application {

    public static void main(String[] args) {
        // http://127.0.0.1:3344/master/cloud-config-dev.yml
        SpringApplication.run(AlbrusCloudConfigClient3366Application.class, args);
    }

}
