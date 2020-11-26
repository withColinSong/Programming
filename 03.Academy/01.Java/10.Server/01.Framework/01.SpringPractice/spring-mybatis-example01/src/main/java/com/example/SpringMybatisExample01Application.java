package com.example;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class SpringMybatisExample01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisExample01Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public void test() {
		User user = new User();
		user.setId(1L);
		user.setEmail("song@test.com");
		user.setPassword("1234abcd");
		user.setJoinedDate(LocalDateTime.now());
		userRepository.createUser(user);
	}
}
