package com.multicampus.biz.user;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;


public class InsertUserTest {
	public static void main(String[] args) {
		// �����ϼ���.
		
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		
		vo.setId("14324");
		vo.setName("Ȳö��");
		vo.setPassword("09");
		vo.setRole("��");
		userDAO.insertUser(vo);
		
		userDAO.getUserList(vo);
		
	}
}
