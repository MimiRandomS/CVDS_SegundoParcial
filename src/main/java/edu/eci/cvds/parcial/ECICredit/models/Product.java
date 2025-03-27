package edu.eci.cvds.parcial.ECICredit.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@Collation("Product")
public class Product {
    @Id
    private String id;
    private String name;

    public Product(String name) {
        this.name = name;
    }
}