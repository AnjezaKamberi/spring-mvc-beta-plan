package com.betaplan.anjeza.store.repository;

import com.betaplan.anjeza.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    // @Query("SELECT ... ")
}
