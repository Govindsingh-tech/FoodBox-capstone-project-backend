package com.project.foodbox.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodbox.helper.UserFoundException;
import com.project.foodbox.model.Cartitems;
import com.project.foodbox.model.Cusine;
import com.project.foodbox.model.Orderitems;
import com.project.foodbox.model.Role;
import com.project.foodbox.model.User;
import com.project.foodbox.model.UserRole;
import com.project.foodbox.services.CartService;
import com.project.foodbox.services.OrderService;
import com.project.foodbox.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> userroles=new HashSet<>();
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Role role=new Role();
		role.setRoleId(102);
		role.setRoleName("USER");
		
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(user);
		userroles.add(userrole);
		
		
		return this.userService.createUser(user, userroles);
	}
	
	@GetMapping("/getcusines")
	public List<Cusine> retrieveAllCusines(){
		List<Cusine> cusines=this.userService.GetAllCusines();
		return cusines;
	}
	
	@GetMapping("/getcusines/{category}")
	public List<Cusine> getCusinesByCategory(@PathVariable("category") String category){
		List<Cusine> cusines=this.userService.getAllCusinesByCategory(category);
		return cusines;
	}
	
	@GetMapping("/{userid}")
	public User getUser(@PathVariable("userid") int userid) {
		return this.userService.getUser(userid);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
	}
	
	@GetMapping("/getcusine/{cusid}")
	public Cusine getCusineByID(@PathVariable("cusid") int cusid){
		return this.userService.getCusineByID(cusid);
	}


    @ExceptionHandler(UserFoundException.class)	
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
    
    @PostMapping("/addtocart")
    public void addToCart(@RequestBody HashMap<String,String> addCartRequest) {
    	int userid=Integer.parseInt(addCartRequest.get("userId"));
    	int cusid=Integer.parseInt(addCartRequest.get("cusId"));
    	int quantity=Integer.parseInt(addCartRequest.get("quantity"));
    	
        this.cartService.addToCart(userid, cusid, quantity);
    }
    
    @PostMapping("/updateQuantity")
    public void updateQuantity(@RequestBody HashMap<String,String> updateDetails) {
    	int itemsId=Integer.parseInt(updateDetails.get("itemsId"));
    	int quantity=Integer.parseInt(updateDetails.get("quantity"));
    	
        this.cartService.updateQuantity(itemsId, quantity);
    }
    
    @DeleteMapping("/removeItem/{itemsId}")
	public void deleteCartitem(@PathVariable("itemsId") int itemsId) {
		this.cartService.deleteByCusine(itemsId);
	}
    
    @GetMapping("/getusercart/{userid}")
	public Set<Cartitems> retrieveAllCusines(@PathVariable("userid") int userid){
		Set<Cartitems> Cartitems=this.cartService.getAllCartitemsByUser(userid);
		return Cartitems;
	}
    
    @PostMapping("/updateAddress")
    public void updateAddress(@RequestBody HashMap<String,String> updateDetails) {
    	int userId=Integer.parseInt(updateDetails.get("userId"));
    	String address=updateDetails.get("address");
        this.userService.updateAddress(userId,address);
    }
    
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody HashMap<String,String> updateDetails) {
    	int userId=Integer.parseInt(updateDetails.get("userId"));
    	String password=updateDetails.get("password");
        this.userService.updatePassword(userId,password);
    }
    
    @PostMapping("/orderitems/{userid}")
    public Set<Orderitems> orderItems(@PathVariable("userid") int userid){
    	return this.orderService.orderitems(userid);
    }
   
}
