
package com.multicampus.biz.user;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

public class GetUserTest {
	public static void main(String[] args) {
		// �����ϼ���.
		UserVO vo = new UserVO();
		vo.setId("14324");
		vo.setPassword("09");
		
		// ȸ�� �˻�
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� �α��� ȯ��");
		} else {
			System.out.println("�α��� ����");
		}
	}
}
