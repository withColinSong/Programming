package com.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	JdbcTemplate jdbcTemp;
	
	@Autowired
	public BoardController(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
		
	}
	
	@RequestMapping(value="board_select", method=RequestMethod.GET)
	public String select() {
		
		String str = "";
		
		try {
			
			Connection conn = jdbcTemp.getDataSource().getConnection();
			String sql = "SELECT mid FROM board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				str += rs.getNString("mid") + "<br/>";
				
			}
			
			System.out.println(str);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return str;
	}
}
