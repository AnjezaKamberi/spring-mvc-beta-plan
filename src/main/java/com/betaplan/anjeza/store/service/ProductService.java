package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.model.Product;
import com.betaplan.anjeza.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * Save new product in db
     * @param product product to save
     */
    public void doAnActionOnProduct(Product product) {
        repository.save(product);
    }

    public Product getProductById(Integer id) {
        Optional<Product> productOptional = repository.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        } else {
            // throw new Exception
            return null;
        }
    }

    public void deleteProductById(Integer id) {
        repository.deleteById(id);
    }
}
