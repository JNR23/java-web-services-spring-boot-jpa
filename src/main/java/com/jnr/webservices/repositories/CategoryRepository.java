package com.jnr.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.webservices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
