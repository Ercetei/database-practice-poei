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

public class UserDAO extends BaseDAO{

	private MySQLRequest rq;
	protected BaseContract contract = new UserContract();

	public UserDAO() {
		super();
		this.rq = new MySQLRequest();
	}
	
	public Object set(ResultSet rs) {
		User user = new User();
		
		try {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setLogin(rs.getString(3));
			user.setPassword(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (Object) user;
	}

	public User select(int id) {
		return (User) super.select(id);
	}

	public List<User> select() {
		/** TODO: à chercher pour demain **/
		List<User> users = new ArrayList<User>();
		for(Object obj: super.select()) {
			users.add((User)obj);
		}
		return users;
	}

	public void insert(User user) {
		this.rq.other("INSERT INTO "+UserContract.TABLE_NAME+" VALUES(null, "
				+ "'"+user.getName()+"', "
				+ "'"+user.getLogin()+"', "
				+ "'"+user.getPassword()+"')");
	}

	public void update(User user) {
		this.rq.other("UPDATE "+UserContract.TABLE_NAME+" SET "
				+ UserContract.ALIASED_NAME +"= '"+user.getName()+"', "
				+ UserContract.ALIASED_LOGIN + "= '"+user.getLogin()+"', "
				+ UserContract.ALIASED_PASSWORD + "= '"+user.getPassword()+"' "
				+ "WHERE " + UserContract.ALIASED_ID + "="+user.getId());
	}

	public void delete(User user) {
        this.rq.other("DELETE FROM "+ UserContract.TABLE_NAME 
                 + " WHERE " +UserContract.ALIASED_ID + "=" + user.getId());
    }

	@Override
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
