package com.softexpert.calculatorms.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softexpert.calculatorms.controller.order.helper.CalculatorControllerTestHelper;
import com.softexpert.calculatorms.controller.order.request.OrderRequest;
import com.softexpert.calculatorms.usecase.order.GetCalculateOrderUseCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private GetCalculateOrderUseCase getCalculateOrderUseCase;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void getCalculate() throws Exception {
        final OrderRequest orderRequest = CalculatorControllerTestHelper.mockOrderRequest();

        this.mockMvc.perform(post("/order/calculate")
                .content(objectMapper.writeValueAsBytes(orderRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(getCalculateOrderUseCase, times(1)).execute(orderRequest);
    }
}
