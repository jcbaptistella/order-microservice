package com.softexpert.calculatorms.service.order.mapper.helper;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class FormatValueMapperHelper {

    private final String PATTERN_FORMAT_VALUE = "#,##0.00";
    private final String PATTERN_DECIMAL_FORMAT = "0.00";

    @Named("formatValue")
    public String formatValue(double value) {
        DecimalFormat formatValue = new DecimalFormat(PATTERN_FORMAT_VALUE);

        return "R$ " + formatValue.format(value).replace(".", ",");
    }

    @Named("formatDoubleToInt")
    public Integer formatDoubleToInt(double value) {
        DecimalFormat formatValue = new DecimalFormat(PATTERN_DECIMAL_FORMAT);

        String format = formatValue.format(value);

        return Integer.parseInt(format.replace(",", ""));
    }
}
