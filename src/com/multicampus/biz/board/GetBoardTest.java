package com.multicampus.biz.board;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class GetBoardTest {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();

		vo.setSeq(5);
		BoardVO board = boardDAO.getBoard(vo);
		System.out.println("<<검색결과 >>");
		System.out.println(board.toString());

	}
}
