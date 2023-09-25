package com.softexpert.calculatorms.config.feign.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSettingsFeignRequest {
    private String message;
    private String payment_method;
    private String expire_at;
    private Boolean request_delivery_address;
}
