package com.lanny.hello.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 所有请求都返回200
 *
 * code有效时
 * {
 *     "session_key": "lWxLnB0HRcYSr538uY96rA==",
 *     "openid": "ochUL413lM7pFX1-dYJLP_uxKcMI"
 * }
 *
 * code无效时
 * {
 *     "errcode": 40029,
 *     "errmsg": "invalid code, hints: [ req_id: Xfhan7aLRa-UZBRFa ]"
 * }
 *
 * code已使用时
 * {
 *     "errcode": 40163,
 *     "errmsg": "code been used, hints: [ req_id: WfhaAgyIRa-RpL8ba ]"
 * }
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenIdResponse {
    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("errcode")
    private String errorCode;

    @JsonProperty("errmsg")
    private String errMsg;
}
