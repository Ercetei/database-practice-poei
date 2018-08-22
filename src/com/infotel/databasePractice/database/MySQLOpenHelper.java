package com.infotel.databasePractice.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySQLOpenHelper {
	/** Instance unique non préinitialisée */
	private static MySQLOpenHelper INSTANCE = null;
	private Connection db;
	
	/** Constructeur privé */
	private MySQLOpenHelper() {
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setServerName("localhost");
			dataSource.setDatabaseName("dbpracticePOEI2018");
			dataSource.setServerTimezone("UTC");
			dataSource.setCreateDatabaseIfNotExist(true);	
			this.db = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static synchronized MySQLOpenHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MySQLOpenHelper();
		}

		return INSTANCE;
	}
	
	public Connection getDb() {
		return db;
	}
	
	public void closeConnection() {
		try {
			this.db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
