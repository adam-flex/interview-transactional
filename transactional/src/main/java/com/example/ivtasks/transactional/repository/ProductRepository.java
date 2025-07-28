package com.example.ivtasks.transactional.repository;

import com.example.ivtasks.transactional.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
