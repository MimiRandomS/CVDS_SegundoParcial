package edu.eci.cvds.ECICredit.service;

import edu.eci.cvds.ECICredit.model.Product;

import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> findByName(String name);
}
