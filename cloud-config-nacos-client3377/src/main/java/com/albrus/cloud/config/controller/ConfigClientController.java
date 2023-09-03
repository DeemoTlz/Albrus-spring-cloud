package com.albrus.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RefreshScope} 支持 Nacos 的动态刷新功能
 */
@RefreshScope
@RestController
@RequestMapping("/config/client")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String getConfigInfo() {
        // http://127.0.0.1:3377/config/client/info
        return this.configInfo;
    }

}
