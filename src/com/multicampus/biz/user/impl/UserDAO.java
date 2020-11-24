package com.multicampus.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.multicampus.biz.common.JDBCUtil;
import com.multicampus.biz.user.vo.UserVO;

// DAO(Data Access Object)
public class UserDAO {
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// SQL 명령어들 등록
	private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
	private String USER_GET    = "select * from users where id=? and password=?";
	private String USER_LIST   = "select * from users order by id asc";
	
	// 회원 등록
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 회원 상세조회
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			// 구현하세요.
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	// 회원 목록조회
	public void getUserList(UserVO vo) {
		try {
			// 구현하세요.
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("PASSWORD");
				String name = rs.getString("NAME");
				String role = rs.getString("ROLE");
				System.out.println(id + " : " + password + " : " + name + " : " + role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
}
