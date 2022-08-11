package com.lenscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerByName(String customerName) throws NoSuchProductFoundException{
		try {
		     Customer customer= customerRepo.findByCustomerName(customerName);
		           return customer;
		     }
		 catch (Exception e){
			throw new NoSuchProductFoundException("No Such Customer Exist");
		}
	}

    public Customer loginCustomer(Customer customer) throws NoSuchProductFoundException {
    	try {
    	      Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
                       if (customer.getPassword().equals(customer1.getPassword())) {
                           return customer1;
                       }
                       else {
                 	        throw new NoSuchProductFoundException("Wrong USername or Password");
                       }
    	     }
        catch(Exception e) {
        	  throw new NoSuchProductFoundException("Wrong USername or Password");
        }
    }



}
