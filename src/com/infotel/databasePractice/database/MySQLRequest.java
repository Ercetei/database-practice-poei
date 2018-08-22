package com.infotel.databasePractice.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLRequest {
	private Statement st;
	
	@SuppressWarnings("finally")
	public ResultSet select (String request) {
		ResultSet rs = null;
		
		try {
			this.st = MySQLOpenHelper.getInstance().getDb().createStatement();
			rs = st.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return rs;
		}
	}
	
	public void other(String request) {
		try {
			this.st = MySQLOpenHelper.getInstance().getDb().createStatement();
			st.executeUpdate(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
