package com.lenscart.service;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.WrongPasswordException;

@Service
public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer getCustomerByName(String customerName);

	public Customer loginCustomer(Customer customer) throws WrongPasswordException;
	
	
	 //public String logoutCustomer(String customerName);
	 
}
