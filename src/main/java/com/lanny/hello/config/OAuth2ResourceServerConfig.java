package com.lanny.hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import static com.lanny.hello.constants.GlobalConstant.RESOURCE_IDS;

/**
 * @EnableResourceServer
 * 配置资源服务器
 *
 * 主要过滤器：OAuth2AuthenticationProcessingFilter
 * 使用AuthenticationManager的实现类OAuth2AuthenticationManager认证token，使用Authentication的实现类OAuth2Authentication来填充Spring Security上下文。
 *
 * TokenExtractor：只有一个实现类BearerTokenExtractor
 * 它的作用在于分离出请求中包含的token。也启示了我们可以使用多种方式携带token
 * request Header中：Authentication：Bearer f732723d-af7f-41bb-bd06-2636ab2be135
 * url拼接：http://localhost:8080/order/1?access_token=f732723d-af7f-41bb-bd06-2636ab2be135
 * form表单(post)：access_token=f732723d-af7f-41bb-bd06-2636ab2be135
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_IDS).stateless(true);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/**").authenticated();
//                .antMatchers("/order/**").authenticated();      //配置order访问控制，必须认证过后才可以访问

    }
}
