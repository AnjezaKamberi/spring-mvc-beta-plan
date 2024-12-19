package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.model.Review;
import com.betaplan.anjeza.store.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public void saveReview(Review review) {
        repository.save(review);
    }
}
