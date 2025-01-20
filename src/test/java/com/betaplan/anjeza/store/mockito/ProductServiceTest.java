package com.betaplan.anjeza.store.mockito;

import com.betaplan.anjeza.store.model.Category;
import com.betaplan.anjeza.store.model.Product;
import com.betaplan.anjeza.store.repository.ProductRepository;
import com.betaplan.anjeza.store.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit testing is the process of testing individual units of code in isolation to ensure they work as expected
 * <p>
 * 1. catch bugs early in development
 * 2. ensure the logic of individual methods works correctly
 * <p>
 * Mockito => library for creating mock objects to simulate the behavior of dependencies
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks // service that you want to test
    private ProductService productService;

    @Mock // dependencies being used in class to test
    private ProductRepository productRepository;

    // test[MethodName]_[ScenarioBeingTested]_[ExpectedBehavior] or given_when_then
    @Test
    public void test_getProductById_OK() {

        // first set up the data and mock dependencies
        var product = new Product();
        product.setId(1);
        product.setName("Laptop");
        product.setDescription("This is a laptop");
        product.setQuantity(10);
        product.setCategory(new Category());

        // what will happen when dependencies will act in your logic?
        when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));

        // call the method being tested
        var result = productService.getProductById(1);

        // verify the output or behavior for this unit
        assertEquals("Laptop", result.getName());
        assertEquals("This is a laptop", result.getDescription());
        assertEquals(10, result.getQuantity());

    }

    @Test
    public void test_getProductById_KO() {

        when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
//        doReturn(Optional.empty()).when(productRepository).findById(Mockito.any()); optional way of mocking

        var result = productService.getProductById(1);
        assertNull(result);

    }

    // TODO add test method for post

    // TODO add test method for put

    // TODO add test method for delete

}
