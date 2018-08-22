package com.infotel.databasePractice;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.databasePractice.contract.UserContract;
import com.infotel.databasePractice.crud.UserDAO;
import com.infotel.databasePractice.database.MySQLOpenHelper;
import com.infotel.databasePractice.database.MySQLRequest;
import com.infotel.databasePractice.model.User;

public class Application {

	public static void main(String[] args) {
		MySQLRequest req = new MySQLRequest();
		
//		UserContract uc = new UserContract();
//		
//		req.other(uc.CREATE_TABLE());
		
		UserDAO crud = new UserDAO();
		crud.createTable();
		crud.delete();
		crud.reset();
		
		User jeanMimi = new User(0, "JeanMi", "JanMiMi", "eljeanmi");
		crud.insert(jeanMimi);
		
		User isJeanMi = crud.select(1);
		jeanMimi.setId(isJeanMi.getId());
		System.out.println(isJeanMi.getName());
		
		jeanMimi.setName("jeanRaoul");
		crud.update(jeanMimi);
		
		User isJeanMi2 = crud.select(1);
		System.out.println(isJeanMi2.getName());

		
		crud.delete(jeanMimi);
		
		for(User user: crud.select()) {
			System.out.println("YOLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		}
		
		MySQLOpenHelper.getInstance().closeConnection();
	}

}
