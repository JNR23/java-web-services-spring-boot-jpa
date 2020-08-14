package com.jnr.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.webservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}