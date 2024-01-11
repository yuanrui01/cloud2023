package com.foresee.springcloud.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2020-02-20 9:40
 */
@Configuration
public class FeignConfig
{
    @Bean
    public Request.Options feignOptions() {
        // 在这里设置超时时间，这里设置的是连接超时为5秒，读取超时为5秒
        return new Request.Options(500, 500);
    }

    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL; // 可以根据需要调整日志级别
    }
}
