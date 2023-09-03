package com.albrus.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlbrusCloudConsumerFeignOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerFeignOrder83Application.class, args);
    }

}
