package com.example.controller;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.member.MemberVo;

@RestController
public class TestController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		String msg = "hi..spring boot Controller Test()";
		return msg;
	}
	
	@RequestMapping(value="/gugudan", method=RequestMethod.GET)
	public ModelAndView gugudan() {
		
		ModelAndView mv = new ModelAndView();
		
		
		String gugudan = "<h3>3단<h3>";
		
		int su = 3;
		for(int i = 1; i <10; i++) {
			String temp = String.format("%d * %d = %d<br/>", su, i, (su*i));
			gugudan += temp;
		}
		
		/*
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				gugudan = i + " * " + j + " = " + (i * j);
				System.out.println(gugudan);
				
			}
		}*/
		
		mv.addObject("gugudan", gugudan);
		mv.setViewName("gugudan");
		return mv;
		
	}
	
	@RequestMapping(value="/loginR", method=RequestMethod.POST) 

		    public ModelAndView loginR(MemberVo vo) {
			ModelAndView mv = new ModelAndView();
			String msg = "로그인 실패";
			
			if(vo.getMid().contentEquals("song") && vo.getPwd().contentEquals("1234")) {
				msg = "로그인 성공";
			}
			
			mv.addObject("msg", msg);
			mv.setViewName("login_result");
			
			return mv;
			
	 	} 
	 	
	  
	 	
		
		
		/*
		  	public String login(MemberVo vo) {
			String result = "";
			
			String mid = "1";
			String pwd = "1234";
			
			vo.setMid(mid);
			vo.setPwd(pwd);
			
			String a = vo.getMid();
			String b = vo.getPwd();
			
			if(!a.equals("1") && !b.equals("1234")) {
				
				result = "<h3>로그인 실패</h3><br/>";
				result += a;
				result += b;
			}else {
				result = "<h3>로그인 성공</h3>";
			}
		

			return result;
		}
		 */
	
	
	@RequestMapping(value="/login", method= {RequestMethod.POST, RequestMethod.GET})
		public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("login");
		return mv;
	}
	
}
