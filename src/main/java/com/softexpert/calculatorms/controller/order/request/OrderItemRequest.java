package com.softexpert.calculatorms.controller.order.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    @NotNull
    @Schema(description = "Nome")
    private String name;

    @NotNull
    @Schema(description = "Valor")
    private Double value;
}
