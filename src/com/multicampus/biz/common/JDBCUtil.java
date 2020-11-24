package com.multicampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			Class.forName(driver);
			return DriverManager.getConnection(url, "hr", "hr");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs,
							 PreparedStatement stmt,
							 Connection conn) {
		try{
			if(rs != null) rs.close();	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}

		try{
			if(stmt != null) stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try{
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
			
		
	}
	
	public static void close( PreparedStatement stmt, Connection conn) {

		try{
			if(stmt != null) stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}

	}
	
}
