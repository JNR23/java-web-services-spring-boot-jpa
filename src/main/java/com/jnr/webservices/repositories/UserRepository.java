package com.jnr.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.webservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}