package com.jnr.webservices.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnr.webservices.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public void findAll() {
		User u = new User(1L, "João Souza", "joao@gmail.com", "99228-5385", "123456");
		System.out.println(u);
	}

}
