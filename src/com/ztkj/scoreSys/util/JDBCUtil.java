package com.ztkj.scoreSys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/webdesign?characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PWD = "";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection con = null;
		
		Class.forName(DRIVER);
		
		con = DriverManager.getConnection(URL, USERNAME, PWD);
		
		return con;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection con) throws SQLException{
		if (rs != null) {
			rs.close();
		}
		
		if (pstm != null) {
			pstm.close();
		}
		
		if (con != null) {
			con.close();
		}
	}
}
