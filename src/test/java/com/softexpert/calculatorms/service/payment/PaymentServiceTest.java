package com.softexpert.calculatorms.service.payment;

import com.softexpert.calculatorms.config.feign.PaymentClient;
import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentItemFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentSettingsFeignRequest;
import com.softexpert.calculatorms.config.feign.response.PaymentFeignResponse;
import com.softexpert.calculatorms.service.order.dto.PersonDto;
import com.softexpert.calculatorms.service.order.helper.OrderServiceTestHelper;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import com.softexpert.calculatorms.service.payment.helper.PaymentServiceTestHelper;
import com.softexpert.calculatorms.service.payment.mapper.PaymentServiceMapper;
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

public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentClient paymentClient;

    @Mock
    private PaymentServiceMapper paymentServiceMapper = Mappers.getMapper(PaymentServiceMapper.class);

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void generate() {
        PaymentSettingsFeignRequest paymentSettingsFeignRequest = PaymentServiceTestHelper.mockPaymentSettingsFeignRequest();
        PaymentFeignRequest paymentFeignRequest = PaymentServiceTestHelper.mockPaymentFeignRequest();
        PaymentItemFeignRequest paymentItemFeignRequest = PaymentServiceTestHelper.mockPaymentItemFeignRequest();
        PaymentFeignResponse paymentFeignResponse = PaymentServiceTestHelper.mockPaymentFeignResponse();
        PaymentDto paymentDto = PaymentServiceTestHelper.mockPaymentDto();
        PersonDto personDto = OrderServiceTestHelper.mockPersonDto();
        double totalPayable = 1.0;
        String itemName = "itemName";

        when(paymentServiceMapper.mappingPaymentSettingsFeignRequestBy(anyString(), anyString(), anyString(), anyString())).thenReturn(paymentSettingsFeignRequest);
        when(paymentServiceMapper.mappingPaymentFeignRequestBy(paymentSettingsFeignRequest)).thenReturn(paymentFeignRequest);
        when(paymentServiceMapper.mappingPaymentItemFeignRequestBy(itemName, totalPayable)).thenReturn(paymentItemFeignRequest);
        when(paymentClient.createPayment(paymentFeignRequest)).thenReturn(paymentFeignResponse);
        when(paymentServiceMapper.mappingPaymentDtoBy(paymentFeignResponse)).thenReturn(paymentDto);

        paymentService.generate(personDto, totalPayable);

        verify(paymentServiceMapper, atLeastOnce()).mappingPaymentSettingsFeignRequestBy(anyString(), anyString(), anyString(), anyString());
        verify(paymentServiceMapper, atLeastOnce()).mappingPaymentFeignRequestBy(any(PaymentSettingsFeignRequest.class));
        verify(paymentServiceMapper, atLeastOnce()).mappingPaymentItemFeignRequestBy(anyString(), anyDouble());
        verify(paymentClient, atLeastOnce()).createPayment(any(PaymentFeignRequest.class));
        verify(paymentServiceMapper, atLeastOnce()).mappingPaymentDtoBy(any(PaymentFeignResponse.class));

    }
}
