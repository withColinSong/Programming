package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/ajax/searchKH")
public class searchKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String findStr = "당산지원";
		
		System.out.println("findStr : " + findStr);
		
		MemberDao dao = new MemberDao();
		
		Kh kh = dao.select(findStr);

		System.out.println("dao : " + dao.select(findStr));
		Gson gson = new Gson();
		String result = gson.toJson(kh);
		out.print(result);
		out.close();
		System.out.println(result);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String findStr = request.getParameter("findStr");
		
		MemberDao dao = new MemberDao();
		Kh kh = dao.select(findStr);

		new Gson().toJson(kh, response.getWriter());

	}

}
