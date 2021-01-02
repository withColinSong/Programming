package com.song.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.song.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
		
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			int id = Integer.parseInt(request.getParameter("id"));

			String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
			String JDBC_USER = "song";
			String JDBC_PW ="1234";
			String sql = "SELECT * FROM NOTICE WHERE ID=?";

			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);	
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ResultSet rs = ps.executeQuery();
				rs.next();

				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id =  rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice(id, title, regdate, writer_id, hit, files, content); // 순서중요
				request.setAttribute("notice", notice);
				System.out.println("notice : "  + notice);
				
//				request.setAttribute("title", title);
//				request.setAttribute("regdate", regdate);
//				request.setAttribute("writer_id", writer_id);
//				request.setAttribute("hit", hit);
//				request.setAttribute("files", files);
//				request.setAttribute("content", content);
//				
				rs.close();
				ps.close();
				conn.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// redirect 게시글 등록 목록 페이지, 로그인 페이지
			

			// forward
			request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
		}
		
		
}
