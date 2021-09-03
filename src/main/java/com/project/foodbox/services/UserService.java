package com.project.foodbox.services;

import java.util.List;
import java.util.Set;

import com.project.foodbox.helper.UserFoundException;
import com.project.foodbox.model.Cusine;
import com.project.foodbox.model.User;
import com.project.foodbox.model.UserRole;

public interface UserService {

	//Creating user
	public User createUser(User user,Set<UserRole> userroles) throws UserFoundException;
	//getting user
	public User getUser(int userid);
	//deleting user
	public void deleteUser(int userid);
	//View all cuisines
	public List<Cusine> GetAllCusines();
	//Get cuisine by id
	public Cusine getCusineByID(int cusid);
	//update user address
	public void updateAddress(int userid,String address);
	//update user password
	public void updatePassword(int userid,String password);
	//Get cusine by category
	public List<Cusine> getAllCusinesByCategory(String category);
}
