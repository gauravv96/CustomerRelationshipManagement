package com.customer.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.management.dao.CustomerDao;
import com.customer.management.entity.Customer;
import com.customer.management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerdao;
	
	@Override
	public String insertCustomer(Customer customer) {
		
		
		return customerdao.insertCustomer(customer);
	}

	@Override
	public List<Customer> getCustomersList() {
		
		return customerdao.getCustomerList();
	}

	@Override
	public Customer getcustomerById(int id) {
		
		return customerdao.getCustomerById(id);
		
	}

	@Override
	public String updateCustomers(Customer customer) {
		
		return customerdao.updateCustomers(customer);
	}

	@Override
	public String deletecustomerById(int id) {
		
		return customerdao.deletecustomerById(id);
	}

	@Override
	public String insertMultipleCsutomer(List<Customer> customer) {
		
		return customerdao.insertMultipleCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		
		return customerdao.getCustomersByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomersByLessThanAge(int age) {
		
		return customerdao.getCustomersByLessThanAge(age);
	}

	@Override
	public String updatedFirstName(int id, String firstName) {
		
		return customerdao.updateFirstName(id, firstName);
	}

	
	
	
	
	
	

}
