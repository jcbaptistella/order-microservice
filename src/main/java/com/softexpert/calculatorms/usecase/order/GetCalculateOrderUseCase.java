package com.softexpert.calculatorms.usecase.order;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.controller.order.response.OrderDetailsResponse;
import com.softexpert.calculatorms.service.order.OrderService;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import com.softexpert.calculatorms.usecase.order.mapper.GetCalculateOrderUseCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetCalculateOrderUseCase {

    private final OrderService orderService;
    private final GetCalculateOrderUseCaseMapper getCalculateOrderUseCaseMapper;

    public List<OrderDetailsResponse> execute(OrderRequest orderRequest) {
        OrderDto orderDto = getCalculateOrderUseCaseMapper.mappingOrderDtoBy(orderRequest);

        return orderService.calculate(orderDto).stream().map(getCalculateOrderUseCaseMapper::mappingOrderDetailsResponseBy).collect(Collectors.toList());
    }
}
