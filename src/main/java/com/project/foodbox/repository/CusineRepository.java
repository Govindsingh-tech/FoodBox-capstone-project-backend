package com.project.foodbox.repository;

import org.springframework.stereotype.Repository;

import com.project.foodbox.model.Cusine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CusineRepository extends JpaRepository<Cusine,Integer>{
   public Cusine findByCusid(int cusid);
   
   public Cusine findByCusname(String cusname);
   
   public List<Cusine> findByCategoryLike(String category);
 
}
