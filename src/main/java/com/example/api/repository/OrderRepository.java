package com.example.api.repository;

import com.example.api.entity.Order;
import com.example.api.entity.Product;
import com.example.api.entity.User;
import com.example.api.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByUserAndStatusAndProduct(User user, OrderStatus status, Product product);
    List<Order> findOrdersByUserAndStatus(User user, OrderStatus status);
    List<Order> findOrdersByUser(User user);
}