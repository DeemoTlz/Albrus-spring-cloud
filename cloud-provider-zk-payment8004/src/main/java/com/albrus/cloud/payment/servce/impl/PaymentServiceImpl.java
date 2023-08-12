package com.albrus.cloud.payment.servce.impl;

import com.albrus.cloud.payment.dao.PaymentDao;
import com.albrus.cloud.payment.entity.Payment;
import com.albrus.cloud.payment.model.PaymentBO;
import com.albrus.cloud.payment.servce.PaymentService;
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
}
