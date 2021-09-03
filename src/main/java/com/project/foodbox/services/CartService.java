package com.project.foodbox.services;

import java.util.Set;

import com.project.foodbox.model.Cartitems;

public interface CartService {
	
   public void addToCart(int userid,int cusid,int quantity);
   
   public void updateQuantity(int itemsid,int quantity);
   
   public void deleteByCusine(int itemsid);
   
   public Set<Cartitems> getAllCartitemsByUser(int userid);
}
