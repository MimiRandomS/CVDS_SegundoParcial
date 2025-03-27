package edu.eci.cvds.parcial.ECICredit.service;


import edu.eci.cvds.parcial.ECICredit.models.Product;

import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> findByName(String name);
}