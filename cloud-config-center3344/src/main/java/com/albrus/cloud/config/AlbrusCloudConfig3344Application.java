package com.albrus.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AlbrusCloudConfig3344Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConfig3344Application.class, args);
    }

}
