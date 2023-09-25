package com.softexpert.calculatorms.config.feign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFeignResponse {

    private Integer code;
    private PaymentDetailsFeignResponse data;

}
