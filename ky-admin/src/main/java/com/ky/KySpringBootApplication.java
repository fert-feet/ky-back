package com.ky;/**
 * Created by Ky2Fe on 2022/6/7 23:54
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 启动类
 **/

@SpringBootApplication
@MapperScan("com.ky.mapper")
public class KySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(KySpringBootApplication.class, args);
    }
}