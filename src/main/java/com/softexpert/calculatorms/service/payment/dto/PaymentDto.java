package com.softexpert.calculatorms.service.payment.dto;

import com.softexpert.calculatorms.config.feign.response.PaymentDetailsFeignResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Integer code;
    private PaymentDetailsDto data;
}
