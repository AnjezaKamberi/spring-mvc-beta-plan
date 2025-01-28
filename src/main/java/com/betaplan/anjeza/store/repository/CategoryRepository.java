package com.betaplan.anjeza.store.repository;

import com.betaplan.anjeza.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
