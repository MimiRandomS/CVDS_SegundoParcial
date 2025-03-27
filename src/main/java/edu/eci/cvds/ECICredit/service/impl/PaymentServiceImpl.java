package edu.eci.cvds.ECICredit.service.impl;

import edu.eci.cvds.ECICredit.model.*;
import edu.eci.cvds.ECICredit.model.enums.PaymentStatus;
import edu.eci.cvds.ECICredit.repository.PaymentRepository;
import edu.eci.cvds.ECICredit.service.PaymentService;
import edu.eci.cvds.ECICredit.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Gets all payments recorded in the database.
     *
     * @return A list of Payment objects representing all stored payments.
     */
    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    /**
     * Creates a new payment based on the purchased items and the amount paid.
     *
     * @param date Date of the payment in string format.
     * @param articles List of purchased items, each represented as a tuple with name, quantity, and price.
     * @param totalPaid Total amount paid for the items.
     * @return A Payment object representing the payment created and stored in the database.
     * @throws ParseException If there was an error converting the string date to a Date object.
     */
    @Override
    public Payment createPayment(String date, List<Tuple<String, Integer, Integer>> articles, Integer totalPaid) throws ParseException {
        final List<DetailArticle> detailArticles = new ArrayList<>();
        final Integer totalAmount = articles.stream()
                .mapToInt(article -> {
                    DetailArticle detail = createDetailArticle(article);
                    detailArticles.add(detail);
                    return detail.getQuantity() * detail.getPrice();
                })
                .sum();

        PaymentStatus status = totalAmount.equals(totalPaid) ? PaymentStatus.APPROVED : PaymentStatus.DECLINED;
        Date datePayment = parseDate(date);

        Payment payment = new Payment(datePayment, status, totalAmount, detailArticles, totalPaid);
        return paymentRepository.save(payment);
    }

    private DetailArticle createDetailArticle(Tuple<String, Integer, Integer> article) {
        Optional<Product> product = productService.findByName(article.getFirst());
        Product productForDetail = product.orElseGet(() -> productService.createProduct(new Product(article.getFirst())));
        return new DetailArticle(productForDetail, article.getSecond(), article.getThird());
    }

    private Date parseDate(String date) throws ParseException {
        return DateUtils.convertStringToDate(date);
    }
}
