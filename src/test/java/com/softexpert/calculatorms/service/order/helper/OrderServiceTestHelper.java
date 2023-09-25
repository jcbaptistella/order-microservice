package com.softexpert.calculatorms.service.order.helper;

import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import com.softexpert.calculatorms.service.order.dto.OrderItemDto;
import com.softexpert.calculatorms.service.order.dto.PersonDto;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceTestHelper {

    public static OrderDto mockOrderDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderDto.class);
    }

    public static OrderItemDto mockOrderItemDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderItemDto.class);
    }

    public static OrderDetailsDto mockOrderDetailsDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(OrderDetailsDto.class);
    }

    public static PersonDto mockPersonDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PersonDto.class);
    }
}
