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
		// 1. 검색 정보 추출(검색 기능은 나중에 구현)
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
		// 3. 결과 화면 전송
		// 응답 메시지에 한글을 인코딩한다.
		response.setContentType("text/html; charset=UTF-8");
		// 출력 스트림을 얻어낸다.
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.print("<title>글 목록</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<center>");
		out.print("<h1>글 목록</h1>");
		out.print("<h3>test님 로그인 환영합니다......");
		out.print("<a href='logout.do'>Log-out</a></h3>");
		
		out.print("<!-- 검색 시작 -->");
		out.print("<form action='getBoardList.jsp' method='post'>");
		out.print("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.print("<tr>");
		out.print("<td align='right'>");
		out.print("<select name='searchCondition'>");
		out.print("<option value='TITLE'>제목");
		out.print("<option value='CONTENT'>내용");
		out.print("</select>");
		out.print("<input name='searchKeyword' type='text'/>");
		out.print("<input type='submit' value='검색'/>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("<!-- 검색 종료 -->");
		
		out.print("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.print("<tr>");
		out.print("<th bgcolor='orange' width='100'>번호</th>");
		out.print("<th bgcolor='orange' width='200'>제목</th>");
		out.print("<th bgcolor='orange' width='150'>작성자</th>");
		out.print("<th bgcolor='orange' width='150'>등록일</th>");
		out.print("<th bgcolor='orange' width='100'>조회수</th>");
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
		out.print("<a href='insertBoard.html'>새글 등록</a>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
				
		
		out.close();
	}

}






