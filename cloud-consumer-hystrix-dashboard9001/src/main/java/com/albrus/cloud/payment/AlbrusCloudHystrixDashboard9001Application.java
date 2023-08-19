package com.albrus.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class AlbrusCloudHystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudHystrixDashboard9001Application.class, args);
    }

}
