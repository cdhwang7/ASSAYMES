package com.multicampus.view.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB����
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
				
		// 3. ���ȭ�� ����
		if(user != null) {
			response.sendRedirect("getboardlist.do");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
