package com.example.dianzan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: demo
 * @description: 应用启动类
 * @author: guhq
 * @create: 2019/08/31
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.dianzan.mapper")
public class BaseframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseframeApplication.class, args);
    }

}
