package com.project.foodbox.services;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodbox.model.Cartitems;
import com.project.foodbox.model.Cusine;
import com.project.foodbox.model.User;
import com.project.foodbox.repository.CartitemsRepository;
import com.project.foodbox.repository.CusineRepository;
import com.project.foodbox.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CusineRepository cusineRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartitemsRepository cartitemsRepository;
	
	
	@Override
	public void addToCart(int userid, int cusid, int quantity) {
		
		User user=this.userRepository.findById(userid);
		Cusine cusine=this.cusineRepository.findByCusid(cusid);
		
	    Cartitems cartitem=this.cartitemsRepository.findByCusineAndUser(cusine, user);
	    
	    if(cartitem!=null) {
	    	cartitem.setQuantity(quantity);
	    }else {
	    	
	    	cartitem=new Cartitems();
	    	cartitem.setCusine(cusine);
	    	cartitem.setUser(user);
	    	cartitem.setQuantity(quantity);
	    }
	    this.cartitemsRepository.save(cartitem);
	}

	@Override
	public void updateQuantity(int itemsid, int quantity) {
		Cartitems cartitem=this.cartitemsRepository.findByItemsid(itemsid);
		cartitem.setQuantity(quantity);
		this.cartitemsRepository.save(cartitem);
	}

	@Override
	public void deleteByCusine(int itemsid) {
		this.cartitemsRepository.deleteById(itemsid);
	}
    
	public Set<Cartitems> getAllCartitemsByUser(int userid){
		User user=this.userRepository.findById(userid);
		Set<Cartitems> cartitems=this.cartitemsRepository.findByUser(user);
		return cartitems;
	}
	
}
