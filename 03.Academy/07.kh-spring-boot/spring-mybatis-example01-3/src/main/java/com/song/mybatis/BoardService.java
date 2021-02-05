package com.song.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.board.BoardVo;
import com.song.board.Page;

// Mapper를 실행시키는 클래스

@Service
@Transactional
public class BoardService {
	@Autowired
	BoardMapper mapper;
	
	public List<BoardVo> select() {
		Page page = new Page();
		
		List<BoardVo> list = mapper.select(page);
		System.out.println("BoardService.select()....");
		
		for(BoardVo v : list) {
			System.out.println(v.getMid());
			System.out.println(v.getSubject());
		}
		
		return list;
	}
}
