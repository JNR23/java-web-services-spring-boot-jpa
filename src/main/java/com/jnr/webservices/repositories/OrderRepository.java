package com.jnr.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
