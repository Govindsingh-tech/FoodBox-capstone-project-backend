package com.project.foodbox.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodbox.model.Cartitems;
import com.project.foodbox.model.Orderitems;
import com.project.foodbox.model.User;
import com.project.foodbox.repository.CartitemsRepository;
import com.project.foodbox.repository.OrderitemsRepository;
import com.project.foodbox.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartitemsRepository cartitemsRepository;
	
	@Autowired
	private OrderitemsRepository orderitemsRepository;
	 
	@Override
	public Set<Orderitems> orderitems(int userid) {
		
		User user=this.userRepository.findById(userid);
		Set<Cartitems> cartitems=this.cartitemsRepository.findByUser(user);
		Set<Orderitems> orderitems=new HashSet<>();
		
		for (Cartitems cartitems2 : cartitems) {
			
			Orderitems orderitem=new Orderitems();
			orderitem.setCusname(cartitems2.getCusine().getCusname());
			orderitem.setPrice(cartitems2.getCusine().getPrice());
			orderitem.setQuantity(cartitems2.getQuantity());
			orderitem.setUserid(userid);
		    orderitems.add(this.orderitemsRepository.save(orderitem));
		    this.cartitemsRepository.deleteById(cartitems2.getItemsid());
		}
		return orderitems;
	}

}
