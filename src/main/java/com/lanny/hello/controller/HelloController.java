package com.lanny.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yao lang
 * @version 1.0
 * @date 2020/1/9 14:42
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        log.info("Hello Api is invoked");
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello1() {
        log.info("Hello Api 2 is invoked");
        return "Hello World 2";
    }
}
