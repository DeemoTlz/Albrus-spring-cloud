package com.albrus.cloud.payment.servce.impl;

import com.albrus.cloud.payment.dao.PaymentDao;
import com.albrus.cloud.payment.entity.Payment;
import com.albrus.cloud.payment.model.PaymentBO;
import com.albrus.cloud.payment.servce.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int save(PaymentBO paymentBO) {
        Payment payment = new Payment();
        payment.setSerial(paymentBO.getSerial());
        return paymentDao.save(payment);
    }

    @Override
    public PaymentBO getById(Long id) {
        Payment payment = paymentDao.getById(id);
        return new PaymentBO(payment.getId(), payment.getSerial());
    }

    @HystrixCommand(fallbackMethod = "getByIdLongtimeFallHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    @Override
    public PaymentBO getByIdLongtime(Long id) {
        // 模拟异常
        // int age = 100 / 0;
        // 或者是超长处理时间
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Payment payment = paymentDao.getById(id);
        return new PaymentBO(payment.getId(), payment.getSerial());
    }

    /**
     * 兜底方案
     */
    private PaymentBO getByIdLongtimeFallHandler(Long id) {
        log.warn("Thread: [{}]: failed to get payment by id: [{}].", Thread.currentThread().getName(), id);
        return null;
    }
}
