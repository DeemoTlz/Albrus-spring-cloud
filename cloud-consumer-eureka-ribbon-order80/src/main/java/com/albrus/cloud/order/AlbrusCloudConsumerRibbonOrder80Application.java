package com.albrus.cloud.order;

import com.albrus.cloud.ribbon.rule.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "ALBRUS-CLOUD-PAYMENT-SERVICE", configuration = RibbonConfiguration.class)
public class AlbrusCloudConsumerRibbonOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerRibbonOrder80Application.class, args);
    }

}
