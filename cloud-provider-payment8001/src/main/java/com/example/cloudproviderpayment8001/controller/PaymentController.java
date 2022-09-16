package com.example.cloudproviderpayment8001.controller;

import com.example.cloudapicommons.entity.Payment;
import com.example.cloudapicommons.until.JsonResult;
import com.example.cloudproviderpayment8001.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public JsonResult<Payment> create(@RequestBody Payment payment) {
        final int result = paymentService.create(payment);
        log.info("-- 插入结果：" + result);
        if (result > 0) {
            return new JsonResult<>(200, "success", null);
        } else {
            return new JsonResult<>(400, "fail", null);
        }
    }

    @GetMapping("/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        final Payment result = paymentService.getPaymentById(id);
        log.info("-- 执行操作：");
        if (result != null) {
            return new JsonResult<>(200, "success", result);
        } else {
            return new JsonResult<>(400, "fail", null);
        }
    }
}
