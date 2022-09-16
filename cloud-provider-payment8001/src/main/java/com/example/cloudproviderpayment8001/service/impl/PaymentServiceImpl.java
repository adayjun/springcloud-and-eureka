package com.example.cloudproviderpayment8001.service.impl;

import com.example.cloudapicommons.entity.Payment;
import com.example.cloudproviderpayment8001.mapper.PaymentDao;
import com.example.cloudproviderpayment8001.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
