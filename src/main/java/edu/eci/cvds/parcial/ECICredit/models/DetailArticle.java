package edu.eci.cvds.parcial.ECICredit.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailArticle {
    private Product product;
    private Integer quantity;
    private Integer price;
}