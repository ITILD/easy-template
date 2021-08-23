package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
//@MapperScan("com.example.*.dao")
// 不添加要在每个dao内加@Mapper
@SpringBootApplication//申明让spring boot自动给程序进行必要的配置，这个配置等同于：
//@Configuration ，@EnableAutoConfiguration 和 @ComponentScan 三个配置。
//SpringBoot在没配置@ComponentScan的情况下，默认只扫描和主类处于同包下的Class。

public class TemplateSpb8Application {

    public static void main(String[] args) {
        SpringApplication.run(TemplateSpb8Application.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    启动成功      ヾ(◍°∇°◍)ﾉﾞ\n ");
    }

}


//@SpringBootApplication：