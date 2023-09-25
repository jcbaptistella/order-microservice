package com.softexpert.calculatorms.usecase.order.helper;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.controller.order.response.OrderDetailsResponse;
import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCaseTestHelper {

    public static OrderRequest mockOrderRequest() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderRequest.class);
    }

    public static OrderDto mockOrderDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderDto.class);
    }

    public static OrderDetailsDto mockOrderDetailsDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderDetailsDto.class);
    }

    public static OrderDetailsResponse mockOrderDetailsResponse() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderDetailsResponse.class);
    }
}
