package com.multicampus.view.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 조회할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
				
		// 2. DB연동
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 결과화면 전송
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.print("<title>글 상세</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<center>");
		out.print("<h3>글 상세</h3>");
		out.print("<a href='logout.do'>Log-out</a>");
		out.print("<hr>");
		out.print("<form action='updateBoard.do' method='post'>");
		out.print("<table border='1' cellpadding='0' cellspacing='0'>");
		out.print("<tr>");
		out.print("<td>제목</td>");
		out.print("<td align='left'><input name='title' type='text' value='"+board.getTitle()+"'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>작성자</td>");
		out.print("<td align='left'>test</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>내용</td>");
		out.print("<td align='left'><textarea name='content' cols='40' rows='10'>"+board.getContent()+"</textarea></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>등록일</td>");
		out.print("<td align='left'>"+board.getRegDate()+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>조회수</td>");
		out.print("<td align='left'>"+board.getCnt()+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan='2' align='center'>");
		out.print("<input type='submit' value='글 수정'/>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("<hr>");
		out.print("<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;");
		out.print("<a href='deleteBoard.do?seq="+board.getSeq()+"'>글삭제</a>&nbsp;&nbsp;&nbsp;");
		out.print("<a href='getboardlist.do'>글목록</a>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");

		
		out.close();
		
	}

}
