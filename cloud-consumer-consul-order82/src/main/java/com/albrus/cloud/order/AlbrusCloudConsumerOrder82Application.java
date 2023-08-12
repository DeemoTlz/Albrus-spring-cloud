package com.albrus.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudConsumerOrder82Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerOrder82Application.class, args);
    }

}
