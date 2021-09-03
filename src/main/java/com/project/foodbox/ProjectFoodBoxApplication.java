package com.project.foodbox;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.foodbox.model.Role;
import com.project.foodbox.model.User;
import com.project.foodbox.model.UserRole;
import com.project.foodbox.services.UserService;




@SpringBootApplication
@ComponentScan ({"com.project.foodbox","com.project.foodbox.model","com.project.foodbox.services"})
@EnableJpaRepositories ("com.project.foodbox.repository")
public class ProjectFoodBoxApplication implements CommandLineRunner {
    
	@Autowired
    private UserService userService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectFoodBoxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code..");
		/*
		User user = new User();
		user.setFirstName("Deepak");
		user.setLastName("A N");
		user.setEmail("deep@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
		user.setUsername("admin");
		user.setPhone("9043281385");
		user.setEnabled(true);
		
		Role role=new Role();
		role.setRoleId(101);
		role.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println("user name : " + user1.getUsername());
		*/
	}

}
