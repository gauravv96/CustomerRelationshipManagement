package com.customer.management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.entity.Customer;
import com.customer.management.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
 public class CustomerController {
	

	
	@Autowired
	CustomerService customerService;
	


	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer) {
		
		return customerService.insertCustomer(customer);
	}
	
	@GetMapping("/getall")
	public List<Customer> getCustomerList() {
		
		return customerService.getCustomersList();
		
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id ) {
		
		return customerService.getcustomerById(id);
	}
	
	@PutMapping
	public String updateCustomers(@RequestBody Customer customer) {
		
		return  customerService.updateCustomers(customer);
	}
	
	@DeleteMapping("/{id}")
	public String deletecustomer(@PathVariable int id) {
		
		return customerService.deletecustomerById(id);
	}
	
	@PostMapping
	public String insertMultipleCustomers(@RequestBody List<Customer> customers) {
		return customerService.insertMultipleCsutomer(customers);
		
	}
	
	@GetMapping("/byname/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName){
		return customerService.getCustomerByFirstName(firstName);
	}
	
	@GetMapping("/byage/{age}")
	public List<Customer> getCustomersByLessthanAge(@PathVariable int age){
		
		return customerService.getCustomersByLessThanAge(age);
	}
	
	@PutMapping("/{id}")
	public String updatedFirstName(@PathVariable int id , @RequestBody Map <String , String> request ) {
		String firstName = request.get("firstname");
		
		return customerService.updatedFirstName(id, firstName);
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
