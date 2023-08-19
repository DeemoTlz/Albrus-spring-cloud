package com.albrus.cloud.order.service.impl;

import com.albrus.cloud.common.model.Result;
import com.albrus.cloud.order.service.PaymentFeignService;
import com.albrus.cloud.payment.vo.PaymentVO;
import com.albrus.cloud.payment.vo.param.PaymentVOParams;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignHystrixServiceImpl implements PaymentFeignService {

    @Override
    public Result<PaymentVO> getPaymentById(Long id) {
        return new Result<>(404, "getPaymentById: " + id);
    }

    @Override
    public Result<PaymentVO> getPaymentByIdLongtime(Long id) {
        return new Result<>(404, "getPaymentByIdLongtime: " + id);
    }

    @Override
    public Result<ServiceInstance> getDiscoveryClientInfo() {
        return new Result<>(404, "getDiscoveryClientInfo");
    }

    @Override
    public Result<Integer> create(PaymentVOParams paymentVOParams) {
        return new Result<>(404, "create: " + paymentVOParams);
    }
}
