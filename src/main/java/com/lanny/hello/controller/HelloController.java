package com.lanny.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yao lang
 * @version 1.0
 * @date 2020/1/9 14:42
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());
        return "order id : " + id;
    }
}
