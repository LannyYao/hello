package com.lanny.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/user")
    public Map<String, String> get() {
        log.info("user Api is invoked");

        Map<String, String> user = new HashMap<>();
        user.put("name", "Tom");
        user.put("age", "12");
        user.put("school", "CTO");
        return user;
    }
}
