package com.jmz.onlineassessmentexamportal;

import com.jmz.onlineassessmentexamportal.entity.Role;
import com.jmz.onlineassessmentexamportal.entity.User;
import com.jmz.onlineassessmentexamportal.entity.UserRoles;
import com.jmz.onlineassessmentexamportal.services.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class OnlineAssessmentExamPortal
//		implements CommandLineRunner
{
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OnlineAssessmentExamPortal.class, args);
	}


//	@Override
//	@SneakyThrows
//	public void run(String... args) {
//		User user = new User();
//		user.setFirstname("prabhakar");
//		user.setLastname("dixith");
//		user.setUsername("pd123");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRoles> userRolesSet = new HashSet<>();
//		UserRoles userRoles = new UserRoles();
//		userRoles.setRole(role);
//		userRoles.setUser(user);
//
//		userRolesSet.add(userRoles);
//
//		User user1 = this.userService.createUser(user,userRolesSet);
//		System.out.println(user1.getUsername());


//	}
//
}
