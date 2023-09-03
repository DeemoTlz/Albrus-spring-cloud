package com.albrus.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudConfigClient3377Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConfigClient3377Application.class, args);
    }

}
