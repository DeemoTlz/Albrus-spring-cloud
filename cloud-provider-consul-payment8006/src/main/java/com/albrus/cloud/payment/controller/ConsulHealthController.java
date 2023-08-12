package com.albrus.cloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ConsulHealthController {

    @GetMapping("/health")
    public String Health() {
        log.info("consul health check.");
        return "OK";
    }

}
