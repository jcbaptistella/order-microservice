package com.softexpert.calculatorms.config.feign;

import com.softexpert.calculatorms.config.feign.interceptor.PaymentFeignInterceptor;
import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.response.PaymentFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentLink-sejaefi", url = "${gerencianet.payment.url}", configuration = PaymentFeignInterceptor.class)
public interface PaymentClient {

    @PostMapping()
    PaymentFeignResponse createPayment(@RequestBody PaymentFeignRequest credentialsRequest);
}
