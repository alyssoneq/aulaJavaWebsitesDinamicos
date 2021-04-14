package com.toDoApp;
/*
 * Class to validate user login
 * This is a simple validation
 * Made to test the error message output
 * 
 * */
public class userValidationService {

	public boolean isUserValid(String name, String password) {
		return name.equals("myname") && password.equals("anytext");
	}
}
