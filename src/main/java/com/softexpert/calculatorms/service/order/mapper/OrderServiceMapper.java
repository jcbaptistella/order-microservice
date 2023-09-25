package com.softexpert.calculatorms.service.order.mapper;

import com.softexpert.calculatorms.config.feign.request.PaymentFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentItemFeignRequest;
import com.softexpert.calculatorms.config.feign.request.PaymentSettingsFeignRequest;
import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderItemDto;
import com.softexpert.calculatorms.service.order.mapper.helper.FormatValueMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { FormatValueMapperHelper.class })
public interface OrderServiceMapper {

    @Mapping(target = "totalPayable", source = "totalPayable", qualifiedByName = "formatValue")
    @Mapping(target = "paymentLink", source = "paymentUrl")
    OrderDetailsDto mappingOrderDetailsDtoBy(String namePerson, double totalPayable, String paymentUrl);
}
