package com.softexpert.calculatorms.service.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsDto {
    private Integer charge_id;
    private String status;
    private Integer total;
    private String payment_url;
    private String payment_method;
    private Boolean request_delivery_address;
    private String message;
    private String expire_at;
    private String created_at;
}
