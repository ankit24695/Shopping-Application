package com.shopping.presentation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.module.Customer;
import com.shopping.service.CustomerService;


@RestController
public class CustomerController {
    
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{
		
		Customer newCustomer = customerService.addCustomer(customer);
		
		
		return new ResponseEntity<>(newCustomer, HttpStatus.ACCEPTED);
	}
	
    @PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		
		Customer updatedCustomer = customerService.updateCustomer(customer);
		
		
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}
    
    
    @DeleteMapping("/deletecustomer/{email}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("email") String email) throws CustomerException{
		
		Customer deletedCustomer = customerService.removeCustomer(email);
		
		
		return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
	}
	
    
    @GetMapping("/viewcustomer/{email}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable("email") String email) throws CustomerException{
		
		Customer viewedCustomer = customerService.viewCustomer(email);
		
		
		return new ResponseEntity<>(viewedCustomer, HttpStatus.OK);
	}
    
	@GetMapping("/listofcustomer")
     public ResponseEntity<List<Customer>> listOfCustomer() throws CustomerException{
		
		List<Customer> listOfcustomer = customerService.viewAllCustomer();
		
		
		return new ResponseEntity<>(listOfcustomer, HttpStatus.OK);
	}
    
    
    
}
