package com.hql;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Customer(){};
	
	public Customer(int id, String firstName, String lastName, int age){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String toString(){
		String info = String.format("Customer info: id = %d, firstname = %s, lastname = %s, age = %d", 
														id, firstName, lastName, age);
		return info;
	}
	
}