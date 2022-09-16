package com.example.cloudconsumerorder8002.controller;

import com.example.cloudapicommons.entity.Payment;
import com.example.cloudapicommons.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 这里直接写payment服务所在的服务器ip和端口，然后通过Spring的restTemplate直接发送post或者get请求，
 * 从而达到服务相互调用的目的。有人说，这样就已经达到目的了，服务在不同的服务器，也能相互调用，
 * 为什么还要学其他的呢？因为，这样调用不好做服务的协调与管理。需要一个中间商，来维护管理这些服务，做服务的注册与发现。
 * springCloud支持的中间商有很多，如开篇说的eureka、zookeeper和nacos。
 *
 * @author z
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    // 上面那个服务的 URL 地址
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    @GetMapping("/payment/create")
    public JsonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResult.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/payment/get/{id}")
    public JsonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, JsonResult.class);
    }

}
