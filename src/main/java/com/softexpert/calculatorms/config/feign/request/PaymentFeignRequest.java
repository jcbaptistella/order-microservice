package com.softexpert.calculatorms.config.feign.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFeignRequest {
    private List<PaymentItemFeignRequest> items;
    private PaymentSettingsFeignRequest settings;
}
