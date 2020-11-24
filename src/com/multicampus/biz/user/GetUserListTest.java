package com.multicampus.biz.user;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;


public class GetUserListTest {
	public static void main(String[] args) {
		// 구현하세요.
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		
		userDAO.getUserList(vo);

	}
}
