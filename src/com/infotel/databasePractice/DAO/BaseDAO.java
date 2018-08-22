package com.infotel.databasePractice.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infotel.databasePractice.contract.BaseContract;
import com.infotel.databasePractice.contract.UserContract;
import com.infotel.databasePractice.database.MySQLRequest;
import com.infotel.databasePractice.model.User;

public abstract class BaseDAO {
	protected MySQLRequest rq;
	protected BaseContract contract;

	public BaseDAO() {
		this.rq = new MySQLRequest();
	}
	
	protected abstract Object set(ResultSet rs);

	public Object select(int id) {
		Object obj = new Object();
		ResultSet rs = this.rq
				.select("SELECT * FROM " + contract.TABLE_NAME 
						+ " WHERE " + " " + contract.FIELDS.get("id") + " = " + id);
		try {
			while (rs.next()) {
				obj = this.set(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	public List<Object> select() {
		List<Object> objs = new ArrayList<Object>();
		ResultSet rs = this.rq.select("SELECT * FROM " + contract.TABLE_NAME);
		
		try {
			while (rs.next()) {
				objs.add(this.set(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objs;
	}

	public abstract void insert(Object obj);

	public abstract void update(Object obj);

	public abstract void delete(Object obj);
	
	public void delete() {
		this.rq.other("DELETE FROM "+contract.TABLE_NAME);
	}

	public void reset() {
		this.rq.other("ALTER TABLE "+contract.TABLE_NAME+" AUTO_INCREMENT = 1");
	}
}
