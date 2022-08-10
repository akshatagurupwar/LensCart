package com.lenscart.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "customer")

public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "customerId")
    private int customerId;
	
	@Column(name = "customerName")
    private String customerName;
	
	@Column(name = "email")
    private String email;
	
	@Column(name ="number")
    private String number;
	
	@Column(name = "password")
	private String password;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerName, String email, String number, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.number = number;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
	
	

	
}
