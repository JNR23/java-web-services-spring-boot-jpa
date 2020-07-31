package com.jnr.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jnr.webservices.entities.Category;
import com.jnr.webservices.entities.Order;
import com.jnr.webservices.entities.OrderItem;
import com.jnr.webservices.entities.Payment;
import com.jnr.webservices.entities.Product;
import com.jnr.webservices.entities.User;
import com.jnr.webservices.entities.enums.OrderStatus;
import com.jnr.webservices.repositories.CategoryRepository;
import com.jnr.webservices.repositories.OrderItemRepository;
import com.jnr.webservices.repositories.OrderRepository;
import com.jnr.webservices.repositories.ProductRepository;
import com.jnr.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		User user1 = new User(null, "John Smith", "johnsmith@gmail.com", "888888888", "123456");
		User user2 = new User(null, "Michael Williams", "mwilliams@gmail.com", "999999999", "454545");
		User user3 = new User(null, "Amy Brown", "amybrown@gmail.com", "777777777", "232323");
		User user4 = new User(null, "Camille Wilson", "camillewln@gmail.com", "55555555", "313131");
		User user5 = new User(null, "Orlando Miller", "orlandomill@gmail.com", "33333333", "858585");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		OrderItem orderItem1 = new OrderItem(order1, product3, 3, product3.getPrice());
		OrderItem orderItem2 = new OrderItem(order2, product4, 2, product4.getPrice());
		OrderItem orderItem3 = new OrderItem(order3, product1, 10, product1.getPrice());
		OrderItem orderItem4 = new OrderItem(order1, product2, 1, product2.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(pay1);
		
		orderRepository.save(order1);

	}
}
