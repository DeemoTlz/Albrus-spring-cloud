package com.albrus.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudPayment8003Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8003Application.class, args);
    }

}
