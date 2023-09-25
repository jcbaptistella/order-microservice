package com.softexpert.calculatorms.controller.order;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.controller.order.response.OrderDetailsResponse;
import com.softexpert.calculatorms.usecase.order.GetCalculateOrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final GetCalculateOrderUseCase getCalculateOrderUseCase;

    
    @PostMapping("/calculate")
    public ResponseEntity<List<OrderDetailsResponse>> calculate(@RequestBody @Valid OrderRequest orderRequest) {
        return ResponseEntity.ok(getCalculateOrderUseCase.execute(orderRequest));
    }
}
