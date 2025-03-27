package edu.eci.cvds.ECICredit.repository;

import edu.eci.cvds.ECICredit.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
