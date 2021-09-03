package com.project.foodbox.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cartitems")
public class Cartitems {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int itemsid;
	
	@ManyToOne
	@JoinColumn(name = "cuisine_id",referencedColumnName = "cusid")
    private Cusine cusine;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
 
	public Cartitems() {
	
	}

	public int getItemsid() {
		return itemsid;
	}

	public void setItemsid(int itemsid) {
		this.itemsid = itemsid;
	}
	
	
	public Cusine getCusine() {
		return cusine;
	}

	public void setCusine(Cusine cusine) {
		this.cusine = cusine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
