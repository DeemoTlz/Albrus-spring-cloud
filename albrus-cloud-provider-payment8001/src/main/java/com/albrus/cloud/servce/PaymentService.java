package com.albrus.cloud.servce;

import com.albrus.cloud.model.PaymentBO;

public interface PaymentService {
    int save(PaymentBO paymentBO);
    PaymentBO getById(Long id);
}
