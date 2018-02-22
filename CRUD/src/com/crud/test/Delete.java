package com.crud.test;


import com.curd.dao.UserDao;

public class Delete {
	
	public static void main(String[] args) {
		
		UserDao ud=new UserDao();
		ud.deleteUser(2l);
		System.out.println("record deleted successfully");

	}
}
