package edu.eci.cvds.ECICredit.model;

import edu.eci.cvds.ECICredit.model.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Collation("Payment")
public class Payment {
    @Id
    private String transactionNumber;
    private Date date;
    private PaymentStatus status;
    private Integer totalAmount;
    private List<DetailArticle> articles;
    private Integer totalPaid;

    public Payment(Date date, PaymentStatus status, Integer totalAmount, List<DetailArticle> articles, Integer totalPaid) {
        this.date = date;
        this.status = status;
        this.totalAmount = totalAmount;
        this.articles = articles;
        this.totalPaid = totalPaid;
    }
}
