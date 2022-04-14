package com.example.spmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;//swagger


@EnableOpenApi //swagger
@SpringBootApplication
public class SpmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpmvcApplication.class, args);
    }

}
