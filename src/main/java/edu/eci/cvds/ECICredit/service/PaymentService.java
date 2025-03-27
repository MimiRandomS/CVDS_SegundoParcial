package edu.eci.cvds.ECICredit.service;


import edu.eci.cvds.ECICredit.model.Payment;
import edu.eci.cvds.ECICredit.model.Tuple;

import java.text.ParseException;
import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment createPayment(String date, List<Tuple<String, Integer, Integer>> articles, Integer totalPaid) throws ParseException;
}
