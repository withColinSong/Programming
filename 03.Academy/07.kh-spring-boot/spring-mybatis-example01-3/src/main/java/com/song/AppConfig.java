package com.song;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.song.board.BoardDao;
import com.song.board.BoardVo;



// Spring boot DI를 구성하는 또 다른 방법

@Aspect
@Configuration
public class AppConfig {
	
	Logger logger = LoggerFactory.getLogger(AppConfig.class);
	BoardVo boardVo;
	
	
	// <bean id="board" class="com.song.board.BoardVo"/>
	@Bean
	public BoardVo getBoardVo() {
		return new BoardVo();
	}
	
	@Bean BoardDao getBoardDao() {
		return new BoardDao();
	}
	
	/*
	 
	 @Before("execution(* com.song.*.*(..))")
	public void before(JoinPoint point) {
		System.out.println("실행 메서드 이전에 처리 될 내용");
	} 
	 
	 */
	
	@Before("execution(* com.song.board.*.*(..))")
	public void before(JoinPoint point) {
		System.out.println("실행 메서드 이전에 처리 될 내용");
		logger.info("1111");
	}
	
	
	/*
	@Around("execution(* com.song.*.*(..))")
	public void around(ProceedingJoinPoint point) throws Throwable {
		
		Object object = point.proceed();
		
	}
	*/
	
}
