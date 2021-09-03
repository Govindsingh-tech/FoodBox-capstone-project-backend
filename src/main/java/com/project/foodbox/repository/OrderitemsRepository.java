package com.project.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.foodbox.model.Orderitems;

@Repository
public interface OrderitemsRepository extends JpaRepository<Orderitems,Integer>{
     
}
