package edu.eci.cvds.parcial.ECICredit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.cvds.parcial.ECICredit.models.Payment;
import edu.eci.cvds.parcial.ECICredit.models.PaymentRequest;
import edu.eci.cvds.parcial.ECICredit.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    private ObjectMapper objectMapper;
    private PaymentRequest validRequest;
    private PaymentRequest invalidDateRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
        objectMapper = new ObjectMapper();

        validRequest = new PaymentRequest("25-03-2025", Arrays.asList(), 3050);
        invalidDateRequest = new PaymentRequest("invalid-date", Arrays.asList(), 3050);
    }

    @Test
    void shouldReturnAllPayments() throws Exception {
        when(paymentService.getAll()).thenReturn(List.of(new Payment()));

        mockMvc.perform(get("/ECICredit/Payment/getAll"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").isArray());

        verify(paymentService, times(1)).getAll();
    }

    @Test
    void shouldCreatePaymentSuccessfully() throws Exception {
        when(paymentService.createPayment(anyString(), anyList(), anyInt()))
                .thenReturn(new Payment());

        mockMvc.perform(put("/ECICredit/Payment/createPayment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest)))
                .andExpect(status().isCreated());

        verify(paymentService, times(1)).createPayment(anyString(), anyList(), anyInt());
    }

    @Test
    void shouldReturnBadRequestForInvalidDate() throws Exception {
        when(paymentService.createPayment(anyString(), anyList(), anyInt()))
                .thenThrow(new ParseException("Invalid date", 0));

        mockMvc.perform(put("/ECICredit/Payment/createPayment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidDateRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Formato de fecha inválido: invalid-date"));

        verify(paymentService, times(1)).createPayment(anyString(), anyList(), anyInt());
    }
}