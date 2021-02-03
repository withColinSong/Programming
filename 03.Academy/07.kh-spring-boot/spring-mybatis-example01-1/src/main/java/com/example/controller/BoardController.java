package com.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.member.MemberVo;

@RestController
public class BoardController {
	JdbcTemplate jdbcTemp;
	
	@Autowired
	public BoardController(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
		
	}
	
	@RequestMapping(value="select", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView selectMember(String findStr) {
		
		ModelAndView mv = new ModelAndView();
		List<MemberVo> list = new ArrayList<>();
		
		String sql = "SELECT * FROM members WHERE mid LIKE ? OR name LIKE ? OR phone LIKE ? OR email LIKE ? ";
		
		try {
		
			Connection conn = jdbcTemp.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, "%"+findStr+"%");
			ps.setNString(2, "%"+findStr+"%");
			ps.setNString(3, "%"+findStr+"%");
			ps.setNString(4, "%"+findStr+"%");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMid(rs.getString("mid"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				
				list.add(vo);
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.addObject("list", list);
		mv.setViewName("member/select");
		
		return mv;
	}
	
	@RequestMapping(value="board_select", method=RequestMethod.GET)
	public String select(String mid) {
		
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


