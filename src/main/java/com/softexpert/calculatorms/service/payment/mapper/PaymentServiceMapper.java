package com.softexpert.calculatorms.service.payment.mapper;

import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentItemFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentSettingsFeignRequest;
import com.softexpert.calculatorms.config.feign.response.PaymentFeignResponse;
import com.softexpert.calculatorms.service.order.dto.OrderItemDto;
import com.softexpert.calculatorms.service.order.mapper.helper.FormatValueMapperHelper;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { FormatValueMapperHelper.class })
public interface PaymentServiceMapper {

    @Mapping(target = "message", source = "messagePayment")
    @Mapping(target = "payment_method", source = "paymentMethod")
    @Mapping(target = "expire_at", source = "expireAt")
    @Mapping(target = "request_delivery_address", source = "requestDeliveryAddress")
    PaymentSettingsFeignRequest mappingPaymentSettingsFeignRequestBy(String messagePayment, String paymentMethod, String expireAt, String requestDeliveryAddress);

    @Mapping(target = "amount", constant = "1")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "totalPayable", qualifiedByName = "formatDoubleToInt")
    PaymentItemFeignRequest mappingPaymentItemFeignRequestBy(String name, double totalPayable);


    PaymentFeignRequest mappingPaymentFeignRequestBy(PaymentSettingsFeignRequest settings);

    @Mapping(target = "code", source = "payment.code")
    @Mapping(target = "data", source = "payment.data")
    PaymentDto mappingPaymentDtoBy(PaymentFeignResponse payment);
}
