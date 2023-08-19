package com.albrus.cloud.payment.controller;

import com.albrus.cloud.common.model.Result;
import com.albrus.cloud.payment.vo.PaymentVO;
import com.albrus.cloud.payment.vo.param.PaymentVOParams;
import com.albrus.cloud.payment.model.PaymentBO;
import com.albrus.cloud.payment.servce.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final DiscoveryClient discoveryClient;

    private final PaymentService paymentService;

    @Value("${spring.application.name}")
    private String applicationName;

    public PaymentController(DiscoveryClient discoveryClient, PaymentService paymentService) {
        this.discoveryClient = discoveryClient;
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/{id}")
    public Result<PaymentVO> getPaymentById(@PathVariable("id") Long id) {
        // http://127.0.0.1:8001/payment/-31
        PaymentBO payment = paymentService.getById(id);
        log.info("Thread: [{}]: the result of get payment by id: [{}] is [{}].", Thread.currentThread().getName(), id, payment);

        if (payment != null) {
            return new Result<>(200, "查询成功", new PaymentVO(payment.getId(), payment.getSerial()));
        } else {
            return new Result<>(404, "没有对应记录,查询ID: " + id);
        }
    }

    @GetMapping(value = "/longtime/{id}")
    public Result<PaymentVO> getPaymentByIdLongtime(@PathVariable("id") Long id) {
        // http://127.0.0.1:8001/payment/longtime/31
        PaymentBO payment = paymentService.getByIdLongtime(id);
        log.info("Thread: [{}]: the result of get payment by id: [{}] is [{}].", Thread.currentThread().getName(), id, payment);

        if (payment != null) {
            return new Result<>(200, "查询成功", new PaymentVO(payment.getId(), payment.getSerial()));
        } else {
            return new Result<>(404, "没有对应记录,查询ID: " + id);
        }
    }

    @GetMapping(value = "/discoveryClientInfo")
    public Result<ServiceInstance> getDiscoveryClientInfo() {
        log.info("The discovery client is: {}.", discoveryClient);

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("The service is: {}.", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName);
        for (ServiceInstance instance : instances) {
            log.info("The service instance details: {}, {}, {}, {}.", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }

        return new Result<>(200, instances.get(0));
    }

    @PostMapping
    public Result<Integer> create(@RequestBody PaymentVOParams paymentVOParams) {
        PaymentBO paymentBO = new PaymentBO();
        paymentBO.setSerial(paymentVOParams.getSerial());

        int result = paymentService.save(paymentBO);
        log.info("The result of save payment: [{}] is [{}].", paymentVOParams.getSerial(), result);

        if (result > 0) {
            return new Result<>(200, "插入数据库成功", result);
        } else {
            return new Result<>(404, "插入数据库失败", result);
        }
    }

}
