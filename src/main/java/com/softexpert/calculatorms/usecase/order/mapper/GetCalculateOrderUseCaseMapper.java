package com.softexpert.calculatorms.usecase.order.mapper;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.controller.order.response.OrderDetailsResponse;
import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetCalculateOrderUseCaseMapper {
    OrderDto mappingOrderDtoBy(OrderRequest orderRequest);

    OrderDetailsResponse mappingOrderDetailsResponseBy(OrderDetailsDto orderDetailsDto);
}
