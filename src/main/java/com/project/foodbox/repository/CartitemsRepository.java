package com.project.foodbox.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.foodbox.model.Cartitems;
import com.project.foodbox.model.Cusine;
import com.project.foodbox.model.User;

@Repository
public interface CartitemsRepository extends JpaRepository<Cartitems,Integer> {
	
	public Cartitems findByItemsid(int itemsid);

	public Cartitems findByCusineAndUser(Cusine cusine,User user);
	
	public Set<Cartitems> findByUser(User user);
}
