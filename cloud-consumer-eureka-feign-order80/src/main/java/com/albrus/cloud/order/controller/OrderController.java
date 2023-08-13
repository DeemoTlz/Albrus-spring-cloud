package com.albrus.cloud.order.controller;

import com.albrus.cloud.common.model.Result;
import com.albrus.cloud.order.service.PaymentFeignService;
import com.albrus.cloud.payment.vo.PaymentVO;
import com.albrus.cloud.payment.vo.param.PaymentVOParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    private final PaymentFeignService paymentFeignService;

    public OrderController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping(value = "/{id}")
    public Result<PaymentVO> getPaymentById(@PathVariable("id") Long id) {
        // http://127.0.0.1:80/consumer/order/31
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/longtime/{id}")
    public Result<PaymentVO> getPaymentByIdLongtime(@PathVariable("id") Long id) {
        // http://127.0.0.1:80/consumer/order/longtime/31
        return paymentFeignService.getPaymentByIdLongtime(id);
    }

    @PostMapping
    public Result<Integer> create(@RequestBody PaymentVOParams paymentVOParams) {
        // log.info("The result of save payment: [{}] is [{}].", paymentVOParams.getSerial(), result);
        return paymentFeignService.create(paymentVOParams);
    }

}
