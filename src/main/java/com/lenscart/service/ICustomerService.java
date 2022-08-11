package com.lenscart.service;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.NoSuchProductFoundException;

@Service
public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer getCustomerByName(String customerName) throws NoSuchProductFoundException;

	public Customer loginCustomer(Customer customer) throws NoSuchProductFoundException;
	
	
	 
}
