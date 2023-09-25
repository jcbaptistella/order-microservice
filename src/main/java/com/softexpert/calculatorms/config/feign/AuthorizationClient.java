package com.softexpert.calculatorms.config.feign;

import com.softexpert.calculatorms.config.feign.interceptor.AuthorizationFeignInterceptor;
import com.softexpert.calculatorms.config.feign.request.CredentialsFeignRequest;
import com.softexpert.calculatorms.config.feign.response.AuthorizationFeignResponse;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authorization-sejaefi", url = "${gerencianet.authorization.url}", configuration = AuthorizationFeignInterceptor.class)
public interface AuthorizationClient {

    @PostMapping()
    ResponseEntity<AuthorizationFeignResponse> authorize(@RequestBody CredentialsFeignRequest credentialsFeignRequest);
}
