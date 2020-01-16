package com.lanny.hello.config.clients;

import com.lanny.hello.model.OpenIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.lanny.hello.constants.GlobalConstant.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class WxClient {

    @Value("${clients.wx.appid}")
    private String appId;

    @Value("${clients.wx.secret}")
    private String secret;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public OpenIdResponse exchangeOpenId(String code) throws IOException {


        ResponseEntity<String> response = restTemplate.getForEntity(
                getOpenIdUrlFormat(),
                String.class,
                formatVariables(code));

        return response == null ? null : objectMapper.readValue(response.getBody(), OpenIdResponse.class);
    }

    private Map<String, String> formatVariables(String code) {
        Map<String, String> variables = new HashMap<>();
        variables.put("appid", appId);
        variables.put("secret", secret);
        variables.put("js_code", code);
        variables.put("grant_type", WX_GRANT_TYPE_AUTH_CODE);

        return variables;
    }

    private String getOpenIdUrlFormat() {
        return WX_HOST + WX_CODE_2_SESSION_ENDPOINT + "?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
    }

}
