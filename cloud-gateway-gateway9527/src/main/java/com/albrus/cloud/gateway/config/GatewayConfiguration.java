package com.albrus.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator paymentPathRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment_path_route", r -> r.path("/discoveryClientInfo").uri("lb://albrus-cloud-payment-service"))
                .build();
    }

}
