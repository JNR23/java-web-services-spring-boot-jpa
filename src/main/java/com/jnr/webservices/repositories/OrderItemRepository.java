package com.jnr.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.webservices.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
