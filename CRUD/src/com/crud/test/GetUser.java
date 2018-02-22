package com.crud.test;
import com.curd.bean.User;
import com.curd.dao.UserDao;
public class GetUser {
	public static void main(String[] args) {
		
		UserDao ud=new UserDao();
		User user=ud.getUser(1l);
		
		System.out.println("User detail");
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

	}

}
