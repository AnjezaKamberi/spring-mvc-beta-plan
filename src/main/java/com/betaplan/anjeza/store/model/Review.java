package com.betaplan.anjeza.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(value = 1, message = "Vlersimi nuk duhet te jete me i vogel se 1")
    @Max(value = 1, message = "Vlersimi nuk duhet te jete me i madh se 5")
    private Integer star;
    private String comment;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Review() {
    }

    public Review(Integer id, Integer star, String comment, LocalDate date, Product product, User user) {
        this.id = id;
        this.star = star;
        this.comment = comment;
        this.date = date;
        this.product = product;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void onCreate() {
        this.date = LocalDate.now();
    }
}
