package com.newwork;

import java.util.UUID;

import com.database.CRUD;

public class UniqueCode {
	public  String getUniqueCode() {
		String uniqueID = UUID.randomUUID().toString();
		CRUD crud=new CRUD();
		if(crud.isUniqueCode(uniqueID)) {
			return uniqueID;
		}
		return getUniqueCode();
	}
}
