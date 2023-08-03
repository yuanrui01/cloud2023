package com.foresee.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderHystirxControllerTest {

    @Resource
    private OrderHystirxController orderHystirxController;


    /**
     * Should throw an exception when the id is invalid
     */
    @Test
    public void paymentInfoOkWhenIdIsInvalidThenThrowException() {
        int id = -1;
        String expected = "Invalid ID";

        String result = orderHystirxController.paymentInfo_OK(id);

        assertEquals(expected, result);
    }

    /**
     * Should return the correct payment information when the id is valid
     */
    @Test
    public void paymentInfoOkWhenIdIsValid() {
        int id = 1;
        String expected = "Payment successful";

        String result = orderHystirxController.paymentInfo_OK(id);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return the fallback message when the payment system is busy or there is an error in the operation")
    void paymentTimeOutFallbackMethodReturnsFallbackMessage() {
        int id = 1;
        String expectedMessage = "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";

        String actualMessage = orderHystirxController.paymentTimeOutFallbackMethod(id);

        assertEquals(expectedMessage, actualMessage);
    }
}