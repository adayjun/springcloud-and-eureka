package com.example.cloudproviderpayment8001.service;

import com.example.cloudapicommons.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param(("id")) Long id);
}
