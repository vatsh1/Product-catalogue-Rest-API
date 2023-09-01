package com.webapp.controller;

import java.util.Optional;

import com.webapp.model.User;
import com.webapp.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private AdminService adminService;

	// Register user handler
	@PostMapping("/user")
	public ResponseEntity<User> registerAdmin(@RequestBody User user) {
		User a = null;
		try {
			a = this.adminService.registerAdmin(user);
			return ResponseEntity.of(Optional.of(a));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// get admin by id
	@GetMapping("/admin/{id}")
	public ResponseEntity<User> getBook(@PathVariable("id") int id) {

		User admin = this.adminService.getAdminById(id);
		if (admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(admin));
	}

	// get admin by email and password
	@GetMapping("/login/{email}")
	public ResponseEntity<User> loginAdmin(@PathVariable("email") String email) {
		User a = null;
		try {
			a = this.adminService.getAdminByEmail(email);
			return ResponseEntity.of(Optional.of(a));
		} catch (Exception ee) {
			ee.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/loginbyemail/{email}/{password}")
	public ResponseEntity<User> loginUserByEmail(@PathVariable("email") String email,@PathVariable("password") String password) {
		User a = null;
		try {
			a = this.adminService.getUserByEmailAndPass(email,password);
			return ResponseEntity.of(Optional.of(a));
		} catch (Exception ee) {
			ee.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
