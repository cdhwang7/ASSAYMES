package com.multicampus.biz.board;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class UpdateBoardTest {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("DAO ����");
		vo.setContent("�׽�Ʈ");
		vo.setSeq(5);
		
		boardDAO.updateBoard(vo);

		boardDAO.getBoardList(vo);

	}
}