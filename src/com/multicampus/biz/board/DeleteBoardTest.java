package com.multicampus.biz.board;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class DeleteBoardTest {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setSeq(5);
		boardDAO.deleteBoard(vo);
		
		boardDAO.getBoardList(vo);
		
		
	}
}
