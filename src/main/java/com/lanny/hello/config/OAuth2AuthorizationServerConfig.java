package com.lanny.hello.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import static com.lanny.hello.constants.GlobalConstant.RESOURCE_IDS;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        String finalSecret = passwordEncoder.encode("123456");
//        String finalSecret = "{bcrypt}" + passwordEncoder.encode("123456");
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory()

                //client模式
                //client模式下，没有refresh token
                .withClient("client_1")
                .resourceIds(RESOURCE_IDS)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("oauth2")
                .secret(finalSecret)
                .and()

                //密码模式
                .withClient("client_2")
                .resourceIds(RESOURCE_IDS)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("ui")
                .authorities("oauth2")
//                .accessTokenValiditySeconds(5)
//                .refreshTokenValiditySeconds(5)
                .secret(finalSecret);
    }

    /**
     * 认证服务端点配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                //用户管理
                .userDetailsService(userDetailsService)
                //token存到redis
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                //启用oauth2管理
                .authenticationManager(authenticationManager)
                //接收GET和POST
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients();
    }
}