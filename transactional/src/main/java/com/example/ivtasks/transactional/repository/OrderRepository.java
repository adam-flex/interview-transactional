package com.example.ivtasks.transactional.repository;

import com.example.ivtasks.transactional.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
