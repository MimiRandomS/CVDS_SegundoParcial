package edu.eci.cvds.parcial.ECICredit.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class PaymentRequest {
    private String date;
    private List<Tuple<String, Integer, Integer>> articles;
    private Integer totalPaid;

    public PaymentRequest(String date, List<Tuple<String, Integer, Integer>> articles, Integer totalPaid) {
        this.date = date;
        this.articles = articles;
        this.totalPaid = totalPaid;
    }
}