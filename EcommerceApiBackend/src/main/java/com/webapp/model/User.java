package com.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Fname;
	private String Lname;
	private String email;
	private String password;

	public User() {
	}

	public User(int id, String Fname,String Lname, String email, String password) {
		this.id = id;
		this.Fname = Fname;
		this.Lname = Lname;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}
	
	public String getLname() {
		return Lname;
	}

	public void setLname(String Lname) {
		this.Lname = Lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", password=" + password + "]";
	}

}
