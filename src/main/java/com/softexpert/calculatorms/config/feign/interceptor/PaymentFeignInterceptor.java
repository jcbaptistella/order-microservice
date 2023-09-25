package com.softexpert.calculatorms.config.feign.interceptor;

import com.softexpert.calculatorms.config.feign.AuthorizationClient;
import com.softexpert.calculatorms.config.feign.request.CredentialsFeignRequest;
import com.softexpert.calculatorms.config.feign.response.AuthorizationFeignResponse;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@RequiredArgsConstructor
public class PaymentFeignInterceptor implements RequestInterceptor {

    private final AuthorizationClient authorizationClient;


    @Override
    public void apply(RequestTemplate requestTemplate) {
        ResponseEntity<AuthorizationFeignResponse> authorize = authorizationClient.authorize(new CredentialsFeignRequest("client_credentials"));

        String accessToken = Objects.requireNonNull(authorize.getBody()).getAccess_token();
        String tokenType = authorize.getBody().getToken_type();

        String tokenFormatted = tokenType.concat(" ").concat(accessToken);

        requestTemplate.header("Authorization", tokenFormatted);
    }
}
