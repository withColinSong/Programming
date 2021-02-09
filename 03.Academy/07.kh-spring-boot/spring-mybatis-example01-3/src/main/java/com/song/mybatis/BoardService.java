package com.song.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.board.BoardDao;
import com.song.board.BoardVo;
import com.song.board.Page;

// Mapper를 실행시키는 클래스

@Service
@Transactional
public class BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardDao dao;
	
	
	public List<BoardVo> select(Page page) {
		
		List<BoardVo> list = mapper.select(page);
		System.out.println("BoardService.select()....");
		
		dao.select();
		
		/*
		for(BoardVo v : list) {
			System.out.println(v.getMid());
			System.out.println(v.getSubject());
		}
		*/
		
		return list;
	}
	
	public String insert(BoardVo vo) {
		String msg = "게시물이 정상적으로 입력";
		int cnt = mapper.insert(vo);
		return msg;
	}
}
