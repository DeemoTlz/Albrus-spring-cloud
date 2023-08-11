package com.albrus.cloud.payment.servce;

import com.albrus.cloud.payment.model.PaymentBO;

public interface PaymentService {
    int save(PaymentBO paymentBO);
    PaymentBO getById(Long id);
}
