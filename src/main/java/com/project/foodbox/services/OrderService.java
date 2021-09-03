package com.project.foodbox.services;

import java.util.Set;

import com.project.foodbox.model.Orderitems;

public interface OrderService {

	public Set<Orderitems> orderitems(int userid);
}
