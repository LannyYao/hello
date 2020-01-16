package com.lanny.hello.config.clients;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

import static com.lanny.hello.utils.AppUtils.generateCode;

@RequiredArgsConstructor
public class AliSmsClient {

    private final String region;

    private final IAcsClient iAcsClient;

    @Value("${clients.aliyun.sms.template}")
    private String template;

    @Value("${clients.aliyun.sms.sign}")
    private String sign;

    private static final String SMS_DOMAIN = "dysmsapi.aliyuncs.com";

    private static final String SMS_VERSION = "2017-05-25";

    private static final String SMS_ACTION_SEND = "SendSms";

    private static final int VALIDATION_CODE_LENGTH = 4;

    public void sendValidationCode(String phoneNum) throws ClientException {
        String code = generateCode(true, VALIDATION_CODE_LENGTH);
        Map<String, String> attributes = new HashMap<>();
        attributes.put("Action", SMS_ACTION_SEND);
        attributes.put("RegionId", region);
        attributes.put("PhoneNumbers", phoneNum);
        attributes.put("SignName", sign);
        attributes.put("TemplateCode", template);
        attributes.put("TemplateParam", "{code: " + code + "}");

        send(attributes, MethodType.POST);

    }

    private void send(Map<String, String> attributes, MethodType method) throws ClientException {
        CommonRequest request = new CommonRequest();
        request.setMethod(method);
        request.setDomain(SMS_DOMAIN);
        request.setVersion(SMS_VERSION);
        attributes.forEach(request::putQueryParameter);
        iAcsClient.getCommonResponse(request);
    }


}
