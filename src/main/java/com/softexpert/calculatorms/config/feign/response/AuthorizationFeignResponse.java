package com.softexpert.calculatorms.config.feign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationFeignResponse {
    private String access_token;
    private String refresh_token;
    private String expires_in;
    private String expire_at;
    private String token_type;
}
