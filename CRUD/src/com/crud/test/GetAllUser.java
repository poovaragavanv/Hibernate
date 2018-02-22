package com.crud.test;



import java.util.List;

import com.curd.bean.User;
import com.curd.dao.UserDao;

public class GetAllUser {

	public static void main(String[] args) {

		UserDao ud = new UserDao();
		List<User> userList = ud.getUserList();
		for (User user : userList) {
			System.out.print(user.getUsername());
			System.out.print("        ");
			System.out.print(user.getPassword());
			System.out.println();
		}

	}

}
