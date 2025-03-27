package edu.eci.cvds.ECICredit.model;

import java.util.List;

public class PaymentRequest {
    private String date;
    private List<Tuple<String, Integer, Integer>> articles;
    private Integer totalPaid;

    public PaymentRequest() {}

    public PaymentRequest(String date, List<Tuple<String, Integer, Integer>> articles, Integer totalPaid) {
        this.date = date;
        this.articles = articles;
        this.totalPaid = totalPaid;
    }

    public String getDate() {
        return date;
    }

    public List<Tuple<String, Integer, Integer>> getArticles() {
        return articles;
    }

    public Integer getTotalPaid() {
        return totalPaid;
    }
}
