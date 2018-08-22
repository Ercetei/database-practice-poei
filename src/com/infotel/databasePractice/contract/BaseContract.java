package com.infotel.databasePractice.contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotel.databasePractice.database.MySQLRequest;
import com.infotel.databasePractice.model.User;

public abstract class BaseContract {
	public String TABLE_NAME;
	public Map<String, String> FIELDS;
	
	public BaseContract() {
		
	}
	
	public String CREATE_TABLE() {
		return "CREATE TABLE IF NOT EXISTS " + this.TABLE_NAME + "("+this.SELECTABLE_FIELDS()+")";
	};
	
	public String SELECTABLE_FIELDS() {
		StringBuilder sb = new StringBuilder();
		int i = 0;

//		for(String key: this.FIELDS.keySet()) {
//			sb.append(key);
//			sb.append(this.FIELDS.get(key));
//			i++;
//			if (i != this.FIELDS.size()) {
//				sb.append(",");
//			}
//		}
		
		
		for (; i < this.FIELDS.size() - 1; i++) {
			sb.append(this.FIELDS.keySet().toArray()[i] + " " + this.FIELDS.get(this.FIELDS.keySet().toArray()[i])  +",");
		}

		sb.append(this.FIELDS.keySet().toArray()[i] + " " + this.FIELDS.get(this.FIELDS.keySet().toArray()[i]));

		return sb.toString();
	}		
}
