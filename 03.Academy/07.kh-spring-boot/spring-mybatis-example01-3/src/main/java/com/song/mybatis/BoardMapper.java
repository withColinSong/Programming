package com.song.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.song.board.BoardVo;
import com.song.board.Page;

@Repository
@Mapper
public interface BoardMapper {
	//List<String> list = sqlSession.selectList("com.song.mybatis.BoardMapper.select", "song");
	// mapper id 메서드명 / parameterType=""에 해당하는 매개변수를 가져야 함.
	
	public List<BoardVo> select(Page page);
	public int insert(BoardVo vo);
	
}
