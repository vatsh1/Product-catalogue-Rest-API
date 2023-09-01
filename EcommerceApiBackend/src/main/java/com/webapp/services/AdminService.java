package com.webapp.services;

import java.util.List;

import com.webapp.dao.AdminRepository;
import com.webapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	// get all admins
	public List<User> getAdmins() {
		List<User> list = (List<User>) this.adminRepository.findAll();
		return list;
	}

	// get admin by id
	public User getAdminById(int id) {
		User admin = this.adminRepository.findById(id);
		return admin;
	}

	// get admin by email
	public User getAdminByEmail(String email) {
		User admin = this.adminRepository.getUserByEmail(email);
		return admin;
	}

	public User getUserByEmailAndPass(String email,String password) {
		User admin = this.adminRepository.getUserByEmailNdPass(email,password);
		return admin;
	}
	
	
	public User registerAdmin(User admin) {
		User result = this.adminRepository.save(admin);
		return result;
	}
}
