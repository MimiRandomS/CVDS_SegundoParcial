package edu.eci.cvds.parcial.ECICredit.service;



import edu.eci.cvds.parcial.ECICredit.models.Payment;
import edu.eci.cvds.parcial.ECICredit.models.Tuple;

import java.text.ParseException;
import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment createPayment(String date, List<Tuple<String, Integer, Integer>> articles, Integer totalPaid) throws ParseException;
}