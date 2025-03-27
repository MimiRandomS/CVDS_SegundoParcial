package edu.eci.cvds.parcial.ECICredit.service.impl;

import edu.eci.cvds.parcial.ECICredit.models.Product;
import edu.eci.cvds.parcial.ECICredit.repository.ProductRepository;
import edu.eci.cvds.parcial.ECICredit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates and saves a new product in the repository.
     *
     * @param product The product to be created and saved.
     * @return The created product.
     */
    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    /**
     * Finds a product by its name.
     *
     * @param name The name of the product to search for.
     * @return An Optional containing the found product, or empty if not found.
     */
    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}