package edu.eci.cvds.parcial.ECICredit.repository;

import edu.eci.cvds.parcial.ECICredit.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}