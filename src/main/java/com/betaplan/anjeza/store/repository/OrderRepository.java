package com.betaplan.anjeza.store.repository;

import com.betaplan.anjeza.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
