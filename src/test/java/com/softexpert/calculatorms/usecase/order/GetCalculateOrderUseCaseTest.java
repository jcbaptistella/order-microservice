package com.softexpert.calculatorms.usecase.order;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.controller.order.response.OrderDetailsResponse;
import com.softexpert.calculatorms.service.order.OrderService;
import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import com.softexpert.calculatorms.usecase.order.mapper.GetCalculateOrderUseCaseMapper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static com.softexpert.calculatorms.usecase.order.helper.OrderUseCaseTestHelper.mockOrderDetailsDto;
import static com.softexpert.calculatorms.usecase.order.helper.OrderUseCaseTestHelper.mockOrderDetailsResponse;
import static com.softexpert.calculatorms.usecase.order.helper.OrderUseCaseTestHelper.mockOrderDto;
import static com.softexpert.calculatorms.usecase.order.helper.OrderUseCaseTestHelper.mockOrderRequest;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetCalculateOrderUseCaseTest {

    @InjectMocks
    private GetCalculateOrderUseCase calculatorUseCase;

    @Mock
    private OrderService orderService;

    @Mock
    private GetCalculateOrderUseCaseMapper getCalculateOrderUseCaseMapper = Mappers.getMapper(GetCalculateOrderUseCaseMapper.class);


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void execute() {
        OrderRequest orderRequest = mockOrderRequest();
        OrderDto orderDto = mockOrderDto();
        OrderDetailsDto orderDetailsDto = mockOrderDetailsDto();
        OrderDetailsResponse orderDetailsResponse = mockOrderDetailsResponse();

        when(getCalculateOrderUseCaseMapper.mappingOrderDtoBy(orderRequest)).thenReturn(orderDto);
        when(orderService.calculate(orderDto)).thenReturn(Collections.singletonList(orderDetailsDto));
        when(getCalculateOrderUseCaseMapper.mappingOrderDetailsResponseBy(orderDetailsDto)).thenReturn(orderDetailsResponse);

        calculatorUseCase.execute(orderRequest);

        verify(orderService, times(1)).calculate(orderDto);
        verify(getCalculateOrderUseCaseMapper, times(1)).mappingOrderDtoBy(orderRequest);
        verify(getCalculateOrderUseCaseMapper, times(1)).mappingOrderDetailsResponseBy(orderDetailsDto);
    }
}
