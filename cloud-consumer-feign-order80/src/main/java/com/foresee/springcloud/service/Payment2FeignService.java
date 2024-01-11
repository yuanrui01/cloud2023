package com.foresee.springcloud.service;

import com.foresee.springcloud.config.FeignConfig;
import com.foresee.springcloud.entities.CommonResult;
import com.foresee.springcloud.entities.Payment;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther zzyy
 * @create 2020-02-19 23:59
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", contextId = "rubbishFeign", configuration = FeignConfig.class)
public interface Payment2FeignService
{
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id, Request.Options options);
}
