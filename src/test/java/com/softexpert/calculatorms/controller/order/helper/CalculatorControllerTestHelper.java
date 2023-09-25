package com.softexpert.calculatorms.controller.order.helper;

import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class CalculatorControllerTestHelper {

    public static OrderRequest mockOrderRequest() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        return new EasyRandom(parameters).nextObject(OrderRequest.class);
    }
}
