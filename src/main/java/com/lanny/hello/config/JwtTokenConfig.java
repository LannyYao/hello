package com.lanny.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtTokenConfig {

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * token生成处理：指定签名
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("internet_plus");
        return accessTokenConverter;
    }

//    @Bean
//    public TokenEnhancer jwtTokenEnhancer(){
//        return new JwtTokenEnhancer();
//    }
//
//    /**
//     * Jwt token 扩展
//     * Created by Fant.J.
//     */
//    public class JwtTokenEnhancer implements TokenEnhancer {
//        @Override
//        public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
//
//            Map<String,Object> info = new HashMap<>();
//            info.put("provider","Fant.J");
//            //设置附加信息
//            ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
//            return oAuth2AccessToken;
//        }
//    }
}
