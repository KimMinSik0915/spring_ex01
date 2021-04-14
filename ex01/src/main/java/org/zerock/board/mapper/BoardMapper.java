package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.vo.BoardVO;

public interface BoardMapper {
	
	// 1. 게시판 리스트
	public List<BoardVO> list();

	// 3. 게시판 글 쓰기
	public int write(BoardVO vo);
	
}
