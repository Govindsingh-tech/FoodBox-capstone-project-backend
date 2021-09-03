package com.project.foodbox.helper;

public class UserFoundException extends Exception {
	public UserFoundException() {
        super("User with this username already exists in database..Try with other usernames !!");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
