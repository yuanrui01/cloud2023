package com.foresee.springcloud.alibaba.controller;

import com.foresee.springcloud.alibaba.domain.CommonResult;
import com.foresee.springcloud.alibaba.domain.Order;
import com.foresee.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @PostMapping("/order/create")
    public CommonResult create(@RequestBody Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
