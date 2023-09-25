package com.softexpert.calculatorms.service.order;

import com.softexpert.calculatorms.service.order.dto.OrderDetailsDto;
import com.softexpert.calculatorms.service.order.dto.OrderDto;
import com.softexpert.calculatorms.service.order.dto.OrderItemDto;
import com.softexpert.calculatorms.service.order.dto.PersonDto;
import com.softexpert.calculatorms.service.order.mapper.OrderServiceMapper;
import com.softexpert.calculatorms.service.payment.PaymentService;
import com.softexpert.calculatorms.service.payment.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderServiceMapper orderServiceMapper;

    private final PaymentService paymentService;

    public List<OrderDetailsDto> calculate(OrderDto orderDto) {
        List<OrderDetailsDto> orderDetailsDto = new ArrayList<>();

        double totalValueItems = getTotalValueItems(orderDto);

        orderDto.getPersons().forEach(personDto -> {
            double totalItemsPerPerson = getTotalItemsPerPerson(personDto);
            double proportionPerPerson = getProportionPerPerson(totalItemsPerPerson, totalValueItems);
            double valueDeliveryTax = getValueDeliveryTax(orderDto, proportionPerPerson);
            double valueWaiterTax = getWaiterTax(orderDto, proportionPerPerson);
            double valueDiscount = getValueDiscount(orderDto, proportionPerPerson);

            double totalPayable = calculate(personDto, valueDeliveryTax, valueWaiterTax, valueDiscount);

            PaymentDto paymentDto = paymentService.generate(personDto, totalPayable);

            orderDetailsDto.add(orderServiceMapper.mappingOrderDetailsDtoBy(personDto.getName(), totalPayable, paymentDto.getData().getPayment_url()));
        });

        return orderDetailsDto;
    }

    private double getTotalValueItems(OrderDto orderDto) {
        return orderDto.getPersons().stream().flatMap(person -> person.getOrderItems().stream()).mapToDouble(OrderItemDto::getValue).sum();
    }

    private double calculate(PersonDto personDto, double valueDeliveryTax, double valueWaiterTax, double valueDiscount) {
        return getTotalItemsPerPerson(personDto) + valueDeliveryTax + valueWaiterTax - valueDiscount;
    }

    private double getValueDiscount(OrderDto orderDto, double proportionPerPerson) {
        return Objects.isNull(orderDto.getDiscount()) ? 0.0 : proportionPerPerson * orderDto.getDiscount();
    }

    private double getValueDeliveryTax(OrderDto orderDto, double proportionPerPerson) {
        return Objects.isNull(orderDto.getDeliveryTax()) ? 0.0 : proportionPerPerson * orderDto.getDeliveryTax();
    }

    private double getWaiterTax(OrderDto orderDto, double proportionPerPerson) {
        if (Objects.isNull(orderDto.getWaiterTax())) {
            return 0.0;
        }

        double totalValueItemsWithWaiterTax = (getTotalValueItems(orderDto) * orderDto.getWaiterTax()) / 100;

        return totalValueItemsWithWaiterTax * proportionPerPerson;
    }

    private double getProportionPerPerson(double totalItemsPerPerson, double totalValueItems) {
        return totalItemsPerPerson / totalValueItems;
    }

    private double getTotalItemsPerPerson(PersonDto personDto) {
        return personDto.getOrderItems().stream().mapToDouble(OrderItemDto::getValue).sum();
    }
}
