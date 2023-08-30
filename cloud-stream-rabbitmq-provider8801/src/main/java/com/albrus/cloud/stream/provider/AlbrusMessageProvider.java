package com.albrus.cloud.stream.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Supplier;

@Component
public class AlbrusMessageProvider {

    @Bean
    public Supplier<String> albrusSend() {
        return () -> UUID.randomUUID().toString();
    }

}
