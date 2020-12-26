package com.web;

import java.io.IOException;
import java.util.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spaghetti")
public class spaghetti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num_ = request.getParameter("n");
		int num = 0; 
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);	
		}
		
	    String result;

	    if(num % 2 == 0) {
	        result = "짝수";
	    }else {
	        result = "홀수";
	    }
	    
	    String[] names = {"song", "song1"};
	    request.setAttribute("names", names);
	    request.setAttribute("result", result);
	    
	    Map<String, Object> notice = new HashMap<>();
	    notice.put("id", 1);
	    notice.put("title", "좋아요");
	    
	    request.setAttribute("notice", notice);
	    
	    List<String> list = new ArrayList<>();
	    
	    list.add("song_list1");
	    list.add("song_list2");
	    request.setAttribute("list", list);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");
	    dispatcher.forward(request, response);
	    
	 
	}
	
	// forward : 현재 페이지를 이어갈 수 있도록
	// redirect : 현제 페이지와 상관없이 이동
	
	
	
}

