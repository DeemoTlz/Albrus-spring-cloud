package com.albrus.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlbrusCloudPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8001Application.class, args);
    }

}
