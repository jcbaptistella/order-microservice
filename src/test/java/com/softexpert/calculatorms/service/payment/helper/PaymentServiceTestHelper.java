package com.softexpert.calculatorms.service.payment.helper;

import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentItemFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentSettingsFeignRequest;
import com.softexpert.calculatorms.config.feign.response.PaymentFeignResponse;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceTestHelper {

    public static PaymentDto mockPaymentDto() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PaymentDto.class);
    }

    public static PaymentSettingsFeignRequest mockPaymentSettingsFeignRequest() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PaymentSettingsFeignRequest.class);
    }

    public static PaymentFeignRequest mockPaymentFeignRequest() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PaymentFeignRequest.class);
    }

    public static PaymentItemFeignRequest mockPaymentItemFeignRequest() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PaymentItemFeignRequest.class);
    }

    public static PaymentFeignResponse mockPaymentFeignResponse() {
        EasyRandomParameters parameters = new EasyRandomParameters();

        return new EasyRandom(parameters).nextObject(PaymentFeignResponse.class);
    }
}
