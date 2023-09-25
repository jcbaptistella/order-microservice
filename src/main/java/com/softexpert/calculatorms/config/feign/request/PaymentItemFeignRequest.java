package com.softexpert.calculatorms.config.feign.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentItemFeignRequest {
    private Integer amount;
    private String name;
    private Integer value;
}
