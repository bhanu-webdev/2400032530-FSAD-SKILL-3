package com.klu.springjpaskill_8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.springjpaskill_8.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Method
    List<Product> findByCategory(String category);

    // Price Range Filter
    List<Product> findByPriceBetween(double min, double max);

    // JPQL - Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    // JPQL - Expensive products
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findExpensiveProducts(double price);
}