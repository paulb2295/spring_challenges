package com.itschool.challenges.repositories;

import com.itschool.challenges.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
