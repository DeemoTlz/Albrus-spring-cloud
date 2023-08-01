package com.albrus.cloud.dao;

import com.albrus.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int save(Payment payment);

    Payment getById(@Param("id") Long id);
}
