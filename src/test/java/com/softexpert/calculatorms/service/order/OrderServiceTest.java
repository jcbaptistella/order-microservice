package com.softexpert.calculatorms.service.order;

import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import com.softexpert.calculatorms.service.order.dto.PersonDto;
import com.softexpert.calculatorms.service.order.helper.OrderServiceTestHelper;
import com.softexpert.calculatorms.service.order.mapper.OrderServiceMapper;
import com.softexpert.calculatorms.service.payment.PaymentService;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import com.softexpert.calculatorms.service.payment.helper.PaymentServiceTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderServiceMapper orderServiceMapper = Mappers.getMapper(OrderServiceMapper.class);

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculate() {
        OrderDto orderDto = OrderServiceTestHelper.mockOrderDto();
        OrderDetailsDto orderDetailsDto = OrderServiceTestHelper.mockOrderDetailsDto();
        PaymentDto paymentDto = PaymentServiceTestHelper.mockPaymentDto();

        when(orderServiceMapper.mappingOrderDetailsDtoBy(anyString(), anyDouble(), anyString())).thenReturn(orderDetailsDto);
        when(paymentService.generate(any(PersonDto.class), anyDouble())).thenReturn(paymentDto);

        orderService.calculate(orderDto);

        verify(orderServiceMapper, atLeastOnce()).mappingOrderDetailsDtoBy(anyString(), anyDouble(), anyString());
        verify(paymentService, atLeastOnce()).generate(any(PersonDto.class), anyDouble());
    }

    @Test
    public void calculateWithoutWaiterTax() {
        OrderDto orderDto = OrderServiceTestHelper.mockOrderDto();
        orderDto.setWaiterTax(null);
        OrderDetailsDto orderDetailsDto = OrderServiceTestHelper.mockOrderDetailsDto();
        PaymentDto paymentDto = PaymentServiceTestHelper.mockPaymentDto();

        when(orderServiceMapper.mappingOrderDetailsDtoBy(anyString(), anyDouble(), anyString())).thenReturn(orderDetailsDto);
        when(paymentService.generate(any(PersonDto.class), anyDouble())).thenReturn(paymentDto);

        orderService.calculate(orderDto);

        verify(orderServiceMapper, atLeastOnce()).mappingOrderDetailsDtoBy(anyString(), anyDouble(), anyString());
        verify(paymentService, atLeastOnce()).generate(any(PersonDto.class), anyDouble());
    }
}
