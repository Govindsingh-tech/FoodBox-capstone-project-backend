package com.project.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodbox.model.Cusine;
import com.project.foodbox.services.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
     
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add-cusine")
	public Cusine createCusine(@RequestBody Cusine cusine) throws Exception {
		return this.adminService.createCusine(cusine);
	}
	
	@GetMapping("/getcusines")
	public List<Cusine> retrieveAllCusines(){
		List<Cusine> cusines=this.adminService.GetAllCusines();
		return cusines;
	}
	
	@GetMapping("/getcusine/{cusid}")
	public Cusine getCusineByID(@PathVariable("cusid") int cusid){
		return this.adminService.getCusineByID(cusid);
	}
	
	@PostMapping("/update-cusine/{id}")
	public Cusine updateCusineById(@PathVariable("id") int cusid,@RequestBody Cusine cusine){
		return this.adminService.updateCusine(cusid, cusine);
	}
	
	@DeleteMapping("/remove-cusine/{id}")
	public void deleteCusine(@PathVariable("id") int cusid) {
		this.adminService.deleteCusine(cusid);
	}
}
