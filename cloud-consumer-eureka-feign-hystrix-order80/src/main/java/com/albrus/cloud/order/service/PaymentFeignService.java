package com.albrus.cloud.order.service;

import com.albrus.cloud.common.model.Result;
import com.albrus.cloud.order.service.impl.PaymentFeignHystrixServiceImpl;
import com.albrus.cloud.payment.vo.PaymentVO;
import com.albrus.cloud.payment.vo.param.PaymentVOParams;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "ALBRUS-CLOUD-PAYMENT-HYSTRIX-SERVICE", path = "/payment", fallback = PaymentFeignHystrixServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping(value = "/{id}")
    Result<PaymentVO> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/longtime/{id}")
    Result<PaymentVO> getPaymentByIdLongtime(@PathVariable("id") Long id);

    @GetMapping(value = "/discoveryClientInfo")
    Result<ServiceInstance> getDiscoveryClientInfo();

    @PostMapping
    Result<Integer> create(@RequestBody PaymentVOParams paymentVOParams);

}
