package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.model.Category;
import com.betaplan.anjeza.store.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }
}
