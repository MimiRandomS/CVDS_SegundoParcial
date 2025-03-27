package edu.eci.cvds.ECICredit.controller;

import edu.eci.cvds.ECICredit.model.Payment;
import edu.eci.cvds.ECICredit.model.PaymentRequest;
import edu.eci.cvds.ECICredit.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/ECICredit/Payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * Retrieves all payments from the system.
     *
     * @return A ResponseEntity containing the list of all payments and HTTP status ACCEPTED.
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAll() {
        return new ResponseEntity<>(paymentService.getAll(), HttpStatus.ACCEPTED);
    }

    /**
     * Creates a new payment based on the provided request data.
     *
     * @param request The PaymentRequest containing payment details.
     * @return A ResponseEntity containing the created payment with HTTP status CREATED,
     *         or an error message with HTTP status BAD_REQUEST if the date format is invalid.
     */
    @PutMapping("/createPayment")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest request) {
        try {
            Payment payment = paymentService.createPayment(
                    request.getDate(),
                    request.getArticles(),
                    request.getTotalPaid()
            );
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        } catch (ParseException e) {
            return new ResponseEntity<>("Formato de fecha inválido: " + request.getDate(), HttpStatus.BAD_REQUEST);
        }
    }
}
