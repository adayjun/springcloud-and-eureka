package com.example.cloudproviderpayment8001.mapper;


import com.example.cloudapicommons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param(("id")) Long id);

}
