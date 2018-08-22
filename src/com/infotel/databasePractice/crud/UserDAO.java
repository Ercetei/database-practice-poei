package com.infotel.databasePractice.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infotel.databasePractice.DAO.BaseDAO;
import com.infotel.databasePractice.contract.BaseContract;
import com.infotel.databasePractice.contract.UserContract;
import com.infotel.databasePractice.database.MySQLRequest;
import com.infotel.databasePractice.model.User;

public class UserDAO extends BaseDAO<User>{

	public UserDAO() {
		super();
		this.contract = new UserContract();
		this.contract.CREATE_TABLE();
	}

	public void createTable() {
		super.createTable();
	}
	
	public User set(ResultSet rs) {
		User user = new User();
		
		try {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setLogin(rs.getString(3));
			user.setPassword(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public User select(int id) {
		return super.select(id);
	}

	public List<User> select() {
		List<User> users = new ArrayList<User>();
		
		for(Object obj: super.select()) {
			users.add((User)obj);
		}
		
		return users;
	}

	public void insert(User user) {
		this.rq.other("INSERT INTO "+contract.TABLE_NAME+" VALUES(null,"
				+ contract.FIELDS.keySet().toArray()[1] +"= '"+user.getName()+"', "
				+ contract.FIELDS.keySet().toArray()[2] + "= '"+user.getLogin()+"', "
				+ contract.FIELDS.keySet().toArray()[3] + "= '"+user.getPassword()+"') ");		
	}

	public void update(User user) {
		this.rq.other("UPDATE "+contract.TABLE_NAME+" SET "
				+ contract.FIELDS.keySet().toArray()[1] +"= '"+user.getName()+"', "
				+ contract.FIELDS.keySet().toArray()[2] + "= '"+user.getLogin()+"', "
				+ contract.FIELDS.keySet().toArray()[3] + "= '"+user.getPassword()+"' "
				+ "WHERE " + contract.FIELDS.keySet().toArray()[0] + "="+user.getId());
	}

	public void delete(User user) {
        this.rq.other("DELETE FROM "+ contract.TABLE_NAME 
                 + " WHERE " +contract.FIELDS.keySet().toArray()[0] + "=" + user.getId());
    }
	
	public void delete() {
		super.delete();
	}

	public void reset() {
		super.reset();
	}

}
