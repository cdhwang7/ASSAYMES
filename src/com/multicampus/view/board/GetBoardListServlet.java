package com.multicampus.view.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. �˻� ���� ����(�˻� ����� ���߿� ����)
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
		// 3. ��� ȭ�� ����
		// ���� �޽����� �ѱ��� ���ڵ��Ѵ�.
		response.setContentType("text/html; charset=UTF-8");
		// ��� ��Ʈ���� ����.
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.print("<title>�� ���</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<center>");
		out.print("<h1>�� ���</h1>");
		out.print("<h3>test�� �α��� ȯ���մϴ�......");
		out.print("<a href='logout.do'>Log-out</a></h3>");
		
		out.print("<!-- �˻� ���� -->");
		out.print("<form action='getBoardList.jsp' method='post'>");
		out.print("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.print("<tr>");
		out.print("<td align='right'>");
		out.print("<select name='searchCondition'>");
		out.print("<option value='TITLE'>����");
		out.print("<option value='CONTENT'>����");
		out.print("</select>");
		out.print("<input name='searchKeyword' type='text'/>");
		out.print("<input type='submit' value='�˻�'/>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("<!-- �˻� ���� -->");
		
		out.print("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.print("<tr>");
		out.print("<th bgcolor='orange' width='100'>��ȣ</th>");
		out.print("<th bgcolor='orange' width='200'>����</th>");
		out.print("<th bgcolor='orange' width='150'>�ۼ���</th>");
		out.print("<th bgcolor='orange' width='150'>�����</th>");
		out.print("<th bgcolor='orange' width='100'>��ȸ��</th>");
		out.print("</tr>");
		
		for (BoardVO board : boardList) {	
			out.print("<tr>");
			out.print("<td>" + board.getSeq() + "</td>");
			out.print("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
			out.print("<td>" + board.getWriter() + "</td>");
			out.print("<td>" + board.getRegDate() + "</td>");
			out.print("<td>" + board.getCnt() + "</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("<br>");
		out.print("<a href='insertBoard.html'>���� ���</a>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
				
		
		out.close();
	}

}






