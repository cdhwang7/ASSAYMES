package com.multicampus.biz.board;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class InsertBoardTest {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("DAO 제목");
		vo.setWriter("황철도");
		vo.setContent("DAO 내용......");
		boardDAO.insertBoard(vo);
		
		boardDAO.getBoardList(vo);
		
	}
}
