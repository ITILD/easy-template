package com.example.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authorx ianyu
 * @date 2021/1/12
 */
@RestController
public class HelloController {

    @GetMapping("/gewang")
    public String gewang() {
        return "test gewang";
    }
}
