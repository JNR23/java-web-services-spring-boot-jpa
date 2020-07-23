package com.jnr.webservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jnr.webservices.entities.User;
import com.jnr.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "John Smith", "johnsmith@gmail.com", "888888888", "123456");
		User user2 = new User(null, "Michael Williams", "mwilliams@gmail.com", "999999999", "454545");
		User user3 = new User(null, "Amy Brown", "amybrown@gmail.com", "777777777", "232323");
		User user4 = new User(null, "Camille Wilson", "camillewln@gmail.com", "55555555", "313131");
		User user5 = new User(null, "Orlando Miller", "orlandomill@gmail.com", "33333333", "858585");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
	}

}
