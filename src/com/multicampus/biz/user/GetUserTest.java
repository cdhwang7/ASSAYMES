
package com.multicampus.biz.user;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

public class GetUserTest {
	public static void main(String[] args) {
		// 구현하세요.
		UserVO vo = new UserVO();
		vo.setId("14324");
		vo.setPassword("09");
		
		// 회원 검색
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 로그인 환영");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
