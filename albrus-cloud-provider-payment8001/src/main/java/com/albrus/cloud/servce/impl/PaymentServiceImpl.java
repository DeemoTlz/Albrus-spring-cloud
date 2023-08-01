package com.albrus.cloud.servce.impl;

import com.albrus.cloud.dao.PaymentDao;
import com.albrus.cloud.entity.Payment;
import com.albrus.cloud.model.PaymentBO;
import com.albrus.cloud.servce.PaymentService;
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
