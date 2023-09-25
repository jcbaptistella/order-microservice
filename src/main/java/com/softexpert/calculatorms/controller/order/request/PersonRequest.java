package com.softexpert.calculatorms.controller.order.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    @NotNull
    @Schema(description = "Nome")
    private String name;

    @NotNull
    @Schema(description = "Items do pedido")
    private List<@Valid OrderItemRequest> orderItems;
}
