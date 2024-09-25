package com.customer.management.service;

import java.util.List;

import com.customer.management.entity.Customer;

public interface CustomerService {

	String insertCustomer(Customer customer);
	List<Customer> getCustomersList();
	Customer getcustomerById( int id);
    String updateCustomers(Customer customer);
    String deletecustomerById(int id);
    String insertMultipleCsutomer(List<Customer> customer);
    List<Customer> getCustomerByFirstName(String firstName);
    List<Customer> getCustomersByLessThanAge(int age);
    
    String updatedFirstName(int id, String firstName);
    
    
}
