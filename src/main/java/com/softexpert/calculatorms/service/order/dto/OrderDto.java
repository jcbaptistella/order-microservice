package com.softexpert.calculatorms.service.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Double deliveryTax;
    private Integer waiterTax;
    private Double discount;
    private List<PersonDto> persons;
}
