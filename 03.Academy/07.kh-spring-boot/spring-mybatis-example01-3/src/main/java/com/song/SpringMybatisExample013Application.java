package com.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy //aspectJ 활성화
public class SpringMybatisExample013Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisExample013Application.class, args);
	}

}
