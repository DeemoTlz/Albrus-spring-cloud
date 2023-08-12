package com.albrus.cloud.payment.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVOParams implements Serializable {
    private Long id;
    private String serial;
}
