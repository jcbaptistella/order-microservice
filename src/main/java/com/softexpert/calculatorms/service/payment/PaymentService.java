package com.softexpert.calculatorms.service.payment;

import com.softexpert.calculatorms.config.feign.PaymentClient;
import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentItemFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentSettingsFeignRequest;
import com.softexpert.calculatorms.service.order.dto.PersonDto;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import com.softexpert.calculatorms.service.payment.mapper.PaymentServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final String MESSAGE_PAYMENT = "Pagamento divido com seus amigos!";
    private final String PAYMENT_METHOD = "all";
    private final String EXPIRE_AT = "2024-01-01";
    private final String REQUEST_DELIVERY_ADDRESS = "true";

    private final PaymentServiceMapper paymentServiceMapper;

    private final PaymentClient paymentClient;

    public PaymentDto generate(PersonDto personDto, double totalPayable) {
        PaymentSettingsFeignRequest paymentSettingsFeignRequest = paymentServiceMapper.mappingPaymentSettingsFeignRequestBy(MESSAGE_PAYMENT, PAYMENT_METHOD, EXPIRE_AT, REQUEST_DELIVERY_ADDRESS);
        PaymentFeignRequest paymentFeignRequest = paymentServiceMapper.mappingPaymentFeignRequestBy(paymentSettingsFeignRequest);

        List<PaymentItemFeignRequest> paymentItemFeignRequests = new ArrayList<>();
        paymentItemFeignRequests.add(paymentServiceMapper.mappingPaymentItemFeignRequestBy(formatItemName(personDto), totalPayable));

        paymentFeignRequest.setItems(paymentItemFeignRequests);

        return paymentServiceMapper.mappingPaymentDtoBy(paymentClient.createPayment(paymentFeignRequest));
    }

    private String formatItemName(PersonDto personDto) {
        StringBuilder nameItem = new StringBuilder();

        personDto.getOrderItems().forEach(orderItemDto -> nameItem.append(nameItem.isEmpty() ? "" : ", ").append(orderItemDto.getName()));
        return nameItem.toString();
    }
}
