package com.project.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.foodbox.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
    public User findByUsername(String username);
    
    public User findById(int userid);
}
