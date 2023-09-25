package com.softexpert.calculatorms.controller.order.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @Schema(description = "Taxa de entrega do pedido")
    private Double deliveryTax;

    @Schema(description = "Taxa do garçom. (Informar de 0 a 100, equivale a porcentagem)")
    private Integer waiterTax;

    @Schema(description = "Desconto total no pedido")
    private Double discount;

    @NotNull
    @Schema(description = "Pessoas envolvidas")
    private List<@Valid PersonRequest> persons;
}
