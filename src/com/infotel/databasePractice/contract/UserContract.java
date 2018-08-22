package com.infotel.databasePractice.contract;

import java.util.HashMap;
import java.util.Map;

public class UserContract extends BaseContract{

	protected String TABLE_NAME = "user";
	protected Map<String, String> FIELDS;
	
	public UserContract() {
		this.FIELDS = new HashMap<String, String>();
		this.FIELDS.put(TABLE_NAME+".id", "int AUTO_INCREMENT PRIMARY KEY");
		this.FIELDS.put(TABLE_NAME+".name", "VARCHAR(255)");
		this.FIELDS.put(TABLE_NAME+".login", "VARCHAR(255)");
		this.FIELDS.put(TABLE_NAME+".password", "VARCHAR(255)");
	}

	@Override
	public String CREATE_TABLE() {
		// TODO Auto-generated method stub
		return super.CREATE_TABLE();
	}

	@Override
	public String SELECTABLE_FIELDS() {
		// TODO Auto-generated method stub
		return super.SELECTABLE_FIELDS();
	}
	
	
	

//	public static final String TABLE_NAME = "user";
//	
//	public static final String ID = "id";
//	public static final String NAME = "name";
//	public static final String LOGIN = "login";
//	public static final String PASSWORD = "password";	
//	
//	public static final String ALIASED_ID = TABLE_NAME+"."+ID;
//	public static final String ALIASED_NAME = TABLE_NAME+"."+NAME;
//	public static final String ALIASED_LOGIN = TABLE_NAME+"."+LOGIN;
//	public static final String ALIASED_PASSWORD = TABLE_NAME+"."+PASSWORD;
//	
//	protected FIELD<> = {
//			{
//				TABLE_NAME+"."+ID:"int AUTO_INCREMENT PRIMARY KEY",
//				""
//			}
//	}
//
//	public static String CREATE_TABLE() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID + " int AUTO_INCREMENT PRIMARY KEY,");
//		sb.append(NAME + " VARCHAR(255) NOT NULL,");
//		sb.append(LOGIN + " VARCHAR(255) NOT NULL,");
//		sb.append(PASSWORD + " VARCHAR(255) NOT NULL)");
//
//		return sb.toString();
//	}
//
//	public static String[] FIELDS() {
//		String[] result = new String[4];
//		result[0] = ID;
//		result[1] = NAME;
//		result[2] = LOGIN;
//		result[3] = PASSWORD;
//
//		return result;
//	}

	
}
