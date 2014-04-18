package com.example.notes;

public class User {
	private String name;
	private String password;
	
	User(String name, String pass)
	{
		this.name = name;
		this.password = pass;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}

}
