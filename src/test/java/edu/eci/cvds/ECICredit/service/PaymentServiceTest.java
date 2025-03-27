package edu.eci.cvds.ECICredit.service;

import edu.eci.cvds.ECICredit.model.*;
import edu.eci.cvds.ECICredit.model.enums.PaymentStatus;
import edu.eci.cvds.ECICredit.repository.PaymentRepository;
import edu.eci.cvds.ECICredit.service.impl.PaymentServiceImpl;
import edu.eci.cvds.ECICredit.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private ProductServiceImpl productService;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private List<Tuple<String, Integer, Integer>> articles;
    private String validDate;
    private String invalidDate;

    @BeforeEach
    void setUp() {
        validDate = "25-03-2025";
        invalidDate = "invalid-date";

        articles = Arrays.asList(
                new Tuple<>("Laptop", 2, 1500),
                new Tuple<>("Mouse", 1, 50)
        );
    }

    @Test
    void shouldCreatePaymentSuccessfully() throws ParseException {

        when(productService.findByName("Laptop")).thenReturn(Optional.of(new Product("Laptop")));
        when(productService.findByName("Mouse")).thenReturn(Optional.of(new Product("Mouse")));
        when(paymentRepository.save(any(Payment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Payment payment = paymentService.createPayment(validDate, articles, 3050);

        // Assert
        assertNotNull(payment);
        assertEquals(PaymentStatus.APPROVED, payment.getStatus());
        assertEquals(3050, payment.getTotalAmount());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void shouldDeclinePaymentWhenTotalPaidIsIncorrect() throws ParseException {

        when(productService.findByName(anyString())).thenReturn(Optional.of(new Product("Laptop")));
        when(paymentRepository.save(any(Payment.class))).thenAnswer(invocation -> invocation.getArgument(0));


        Payment payment = paymentService.createPayment(validDate, articles, 1000); // Incorrect total


        assertNotNull(payment);
        assertEquals(PaymentStatus.DECLINED, payment.getStatus());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void shouldThrowParseExceptionForInvalidDate() {
        assertThrows(ParseException.class, () -> {
            paymentService.createPayment(invalidDate, articles, 3050);
        });
    }

}
