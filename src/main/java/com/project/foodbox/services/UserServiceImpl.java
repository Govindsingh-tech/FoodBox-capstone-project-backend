package com.project.foodbox.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.foodbox.helper.UserFoundException;
import com.project.foodbox.model.Cusine;
import com.project.foodbox.model.User;
import com.project.foodbox.model.UserRole;
import com.project.foodbox.repository.CusineRepository;
import com.project.foodbox.repository.RoleRepository;
import com.project.foodbox.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CusineRepository cusineRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws UserFoundException {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local!=null) {
			System.out.println("User already exists..");
			throw new UserFoundException();
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserroles().addAll(userRoles);
			
			local=this.userRepository.save(user);
			
		}
		
		return local;
	}

	//getting user
	@Override
	public User getUser(int userid) {
		return this.userRepository.findById(userid);
	}

	//Deleting user
	@Override
	public void deleteUser(int userid) {
		this.userRepository.deleteById(userid);
		
	}
	
	@Override
	public List<Cusine> GetAllCusines() {
		List<Cusine> cusines=this.cusineRepository.findAll();
		return cusines;
	}

	@Override
	public Cusine getCusineByID(int cusid) {
		return this.cusineRepository.findByCusid(cusid);
	}

	@Override
	public void updateAddress(int userid,String address) {
		User user=this.userRepository.findById(userid);
		user.setAddress(address);
		this.userRepository.save(user);
	}

	@Override
	public void updatePassword(int userid,String password) {
		User user=this.userRepository.findById(userid);
		user.setPassword(this.bCryptPasswordEncoder.encode(password));
		this.userRepository.save(user);
	}

	@Override
	public List<Cusine> getAllCusinesByCategory(String category) {
		List<Cusine> cusines=this.cusineRepository.findByCategoryLike(category);
		return cusines;
	}

}
