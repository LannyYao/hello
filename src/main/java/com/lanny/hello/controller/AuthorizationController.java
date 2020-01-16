package com.lanny.hello.controller;

import com.lanny.hello.config.clients.WxClient;
import com.lanny.hello.model.OpenIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthorizationController {

    @Autowired
    private WxClient wxClient;

    @GetMapping("/openid")
    public OpenIdResponse getOpenId(@RequestParam(value = "code") String code) throws IOException {
        return wxClient.exchangeOpenId(code);
    }
}
