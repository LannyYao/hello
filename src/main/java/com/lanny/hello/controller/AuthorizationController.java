package com.lanny.hello.controller;

import com.aliyuncs.exceptions.ClientException;
import com.lanny.hello.config.clients.AliSmsClient;
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

    @Autowired
    private AliSmsClient aliSmsClient;

    @GetMapping("/openid")
    public OpenIdResponse getOpenId(@RequestParam(value = "code") String code) throws IOException {
        return wxClient.exchangeOpenId(code);
    }

    @GetMapping("/validation_code")
    public String sendValidationCode(@RequestParam(value = "phone") String phoneNum) throws ClientException {
        aliSmsClient.sendValidationCode(phoneNum);
        return "Success";
    }
}
