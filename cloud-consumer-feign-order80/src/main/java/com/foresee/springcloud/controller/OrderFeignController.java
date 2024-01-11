package com.foresee.springcloud.controller;

import com.foresee.springcloud.entities.CommonResult;
import com.foresee.springcloud.entities.Payment;
import com.foresee.springcloud.service.Payment2FeignService;
import com.foresee.springcloud.service.PaymentFeignService;
import feign.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * @auther zzyy
 * @create 2020-02-20 0:05
 */
@RestController
@Slf4j
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;

    @Resource
    private Payment2FeignService payment2FeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        long start = Instant.now().toEpochMilli();
        try {
            return paymentFeignService.getPaymentById(id);
        } finally {
            log.info("接口调用时间。。。。" + (Instant.now().toEpochMilli() - start) + "ms" );
        }
    }

    @GetMapping(value = "/consumer/payment/get2/{id}")
    public CommonResult<Payment> get2PaymentById(@PathVariable("id") Long id)
    {
        long start = Instant.now().toEpochMilli();
        try {
            return payment2FeignService.getPaymentById(id, new Request.Options(500, 500));
        } finally {
            log.info("接口调用时间。。。。" + (Instant.now().toEpochMilli() - start) + "ms" );
        }
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
