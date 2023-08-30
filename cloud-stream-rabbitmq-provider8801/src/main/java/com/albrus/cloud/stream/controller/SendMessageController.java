package com.albrus.cloud.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/stream")
public class SendMessageController {

    @Resource
    private StreamBridge streamBridge;

    @PostMapping(value = "/message1")
    public String sendMessage1() {
        Random random = new Random();
        // [0, 100)
        int ranNum = random.nextInt(100);
        String message = "老猪猪 - " + ranNum;
        streamBridge.send("albrusSend1-out-0", message);

        return message;
    }

    @PostMapping(value = "/message2")
    public String sendMessage2() {
        Random random = new Random();
        // [0, 100)
        int ranNum = random.nextInt(100);
        String message = "老鸡屎 - " + ranNum;
        streamBridge.send("albrusSend2-out-0", message);

        return message;
    }

}
