package com.albrus.cloud.stream.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class AlbrusConsumer {

    @Bean
    public Consumer<String> albrusSink() {
        return System.out::println;
    }

}
