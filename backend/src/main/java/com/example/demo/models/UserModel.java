package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserModel {
	
	
	public UserModel( String name, String email, String password, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.amount_left = 50000;
	}

	@Column(name = "name")
	private String name;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private long phone;
	
	@Column(name = "amount_left")
	private int amount_left;

	public String getName() {
		return name;
	}


	public int getAmount_left() {
		return amount_left;
	}


	public void setAmount_left(int amount_left) {
		this.amount_left = amount_left;
	}


	public void setName(String name) {
		this.name = name;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	

	public UserModel()
	{
		
	}

}
