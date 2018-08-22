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

public abstract class BaseDAO<T> {
	protected MySQLRequest rq;
	protected BaseContract contract;

	public BaseDAO() {
		this.rq = new MySQLRequest();
	}
	
	public void createTable() {
		this.rq.other(this.contract.CREATE_TABLE());
	}
	
	protected abstract T set(ResultSet rs);

	public T select(int id) {
		Object obj = new Object();
		ResultSet rs = this.rq
				.select("SELECT * FROM " + this.contract.TABLE_NAME 
						+ " WHERE " + " " +this.contract.FIELDS.get("id") + " = " + id);
		try {
			while (rs.next()) {
				obj = this.set(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (T) obj;
	}

	public List<T> select() {
		List<T> objs = new ArrayList<T>();
		ResultSet rs = this.rq.select("SELECT * FROM " + this.contract.TABLE_NAME);
		
		try {
			while (rs.next()) {
				objs.add(this.set(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objs;
	}

	public abstract void insert(T obj);

	public abstract void update(T obj);

	public abstract void delete(T obj);
	
	public void delete() {
		this.rq.other("DELETE FROM "+this.contract.TABLE_NAME);
	}

	public void reset() {
		this.rq.other("ALTER TABLE "+this.contract.TABLE_NAME+" AUTO_INCREMENT = 1");
	}
}
