package com.lenscart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Customer;
import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.UserAlreadyExistException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.service.ICustomerService;

@RestController
@RequestMapping("/lenscart")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("customer/{customerName}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("customerName") String customerName) {
		return new ResponseEntity<Customer>(customerService.getCustomerByName(customerName), HttpStatus.OK);
	}
	
	/*
	 * // @PostMapping("login") // public ResponseEntity<Customer>
	 * customerLogin(@RequestBody Customer customer){ // Customer result =
	 * customerService.loginCustomer(customer.getCustomerName(),
	 * customer.getPassword()); // ResponseEntity<Customer> response = new
	 * ResponseEntity<>(result, HttpStatus.OK); // return response; // }
	 */	
	
	/*
	 * @GetMapping("/logout/{customer}") public ResponseEntity<String>
	 * logout(@PathVariable(name = "customer") String customerName) { return new
	 * ResponseEntity<String>(customerService.logoutCustomer(customerName),
	 * HttpStatus.OK); }
	 */

	
	
	
    @PostMapping("/login")
    public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer, HttpSession session) throws WrongPasswordException{
    	Customer customer_info = customerService.loginCustomer(customer);
        if (customer_info != null) {
            session.setAttribute("customer", customer_info);
            return new ResponseEntity<>(customer_info, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

	
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        if (session.getAttribute("customer") != null) {
            session.invalidate();
            return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
         } 
        else {
            return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
        }
    }

	
	
	
         
}
