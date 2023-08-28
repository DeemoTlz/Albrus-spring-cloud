package com.albrus.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AlbrusCloudConfigServer3344Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConfigServer3344Application.class, args);
    }

}
