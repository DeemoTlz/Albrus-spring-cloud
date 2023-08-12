package com.albrus.cloud.order.controller;

import com.albrus.cloud.common.model.Result;
import com.albrus.cloud.payment.vo.PaymentVO;
import com.albrus.cloud.payment.vo.param.PaymentVOParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    // private static final String BASE_URL = "http://127.0.0.1:8001";
    /**
     * 通过在 ZooKeeper 上注册过的微服务名称调用
     */
    private static final String BASE_URL = "http://albrus-cloud-payment-service";

    private static final String PAYMENT_URL = BASE_URL + "/payment";

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/{id}")
    public Result<PaymentVO> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/" + id, Result.class);
    }

    @PostMapping
    public Result<Integer> create(@RequestBody PaymentVOParams paymentVOParams) {
        // log.info("The result of save payment: [{}] is [{}].", paymentVOParams.getSerial(), result);
        return restTemplate.postForObject(PAYMENT_URL, paymentVOParams, Result.class);
    }

}
