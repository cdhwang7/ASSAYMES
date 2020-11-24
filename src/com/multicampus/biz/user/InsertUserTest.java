package com.multicampus.biz.user;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;


public class InsertUserTest {
	public static void main(String[] args) {
		// 구현하세요.
		
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		
		vo.setId("14324");
		vo.setName("황철도");
		vo.setPassword("09");
		vo.setRole("아");
		userDAO.insertUser(vo);
		
		userDAO.getUserList(vo);
		
	}
}
