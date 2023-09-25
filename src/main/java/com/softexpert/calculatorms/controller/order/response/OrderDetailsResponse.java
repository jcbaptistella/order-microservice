package com.softexpert.calculatorms.controller.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsResponse {

    private String namePerson;
    private String totalPayable;
    private String paymentLink;
}
