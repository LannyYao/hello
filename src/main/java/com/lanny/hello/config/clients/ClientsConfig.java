package com.lanny.hello.config.clients;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {

    @Value("${clients.aliyun.account.accessKey}")
    private String accessKey;

    @Value("${clients.aliyun.account.accessSecret}")
    private String accessSecret;

    @Value("${clients.aliyun.account.region}")
    private String region;

    @Bean
    public IAcsClient iAcsClient() {
        DefaultProfile profile = DefaultProfile.getProfile(region, accessKey, accessSecret);
        return new DefaultAcsClient(profile);
    }

    @Bean
    public AliSmsClient aliSmsClient() {
        return new AliSmsClient(region, iAcsClient());
    }
}
