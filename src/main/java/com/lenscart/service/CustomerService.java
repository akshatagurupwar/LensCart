package com.lenscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerService implements ICustomerService{
	//private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerRepository customerRepo;
	
	//Customer loggedInCustomer;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerByName(String customerName) {
		Customer customer= customerRepo.findByCustomerName(customerName);
		return customer;
	}

	/*
	 * @Override public Customer loginCustomer(String customerName, String password)
	 * { Customer customer = null;
	 * 
	 * if
	 * (customerRepo.findByCustomerName(customerName).getPassword().equals(password)
	 * ) { customer = customerRepo.findByCustomerName(customerName);
	 * loggedInCustomer=customer; return customer; } else { return null; } }
	 */	
	
    public Customer loginCustomer(Customer customer) throws WrongPasswordException {
    	Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
    	if(customer1!=null)
    	{
              if (customer.getPassword().equals(customer1.getPassword())) {
                   return customer1;
              } 
              else {
                    throw new WrongPasswordException("Wrong Password");
    	      }
    	}
        else {
        	
        	throw new WrongPasswordException("Wrong USernmae and Password");
        }
    }



}
