package com.betaplan.anjeza.store.repository;

import com.betaplan.anjeza.store.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
