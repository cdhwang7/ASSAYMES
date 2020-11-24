package com.multicampus.biz.board;

import java.util.List;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class GetBoardListTest {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		System.out.println("<< ±Û ¸ñ·Ï >>");
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}

	}
}