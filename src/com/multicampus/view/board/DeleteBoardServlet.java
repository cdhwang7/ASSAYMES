package com.multicampus.view.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		vo.setSeq(seq);
		boardDAO.deleteBoard(vo);
		
		response.sendRedirect("getboardlist.do");
	}

}
