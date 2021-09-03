package com.project.foodbox.services;

import java.util.List;
import com.project.foodbox.model.Cusine;


public interface AdminService {

	// Add   Cuisine
	public Cusine createCusine(Cusine cusine) throws Exception;
	//Update Cuisine
	public Cusine updateCusine(int cusid,Cusine cusine);
	//Remove Cuisine
	public void deleteCusine(int cusid);
	//View all Cuisines;
	public List<Cusine> GetAllCusines();
	//Get cuisine by id
	public Cusine getCusineByID(int cusid);
	//Get cuisine by name
	public Cusine getCusineByName(String cusname);
	
}
