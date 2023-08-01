package com.albrus.cloud.controller;

import com.albrus.cloud.controller.vo.PaymentVO;
import com.albrus.cloud.controller.vo.param.PaymentVOParams;
import com.albrus.cloud.model.PaymentBO;
import com.albrus.cloud.model.Result;
import com.albrus.cloud.servce.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
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
            return new Result<>(444, "插入数据库失败", result);
        }
    }

    @GetMapping(value = "/{id}")
    public Result<PaymentVO> getPaymentById(@PathVariable("id") Long id) {
        PaymentBO payment = paymentService.getById(id);
        log.info("The result of get payment by id: [{}] is [{}].", id, payment);

        if (payment != null) {
            return new Result<>(200, "查询成功", new PaymentVO(payment.getId(), payment.getSerial()));
        } else {
            return new Result<>(444, "没有对应记录,查询ID: " + id);
        }
    }

}
