package com.lanny.hello.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalConstant {

    // auth
    public static final String RESOURCE_IDS = "ui";

    public static final String SALT = "internal-plus";

    public static final String ADMIN_USER = "admin";

    //wx
    public static final String WX_HOST = "https://api.weixin.qq.com";

    public static final String WX_GRANT_TYPE_AUTH_CODE = "authorization_code";

    public static final String WX_CODE_2_SESSION_ENDPOINT = "/sns/jscode2session";

}
