package com.customer.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.management.entity.Customer;

@Repository
public class CustomerDao {
	
	@Autowired //(1st Way- All methods of sessionfactory will be handled by IOC container)
	SessionFactory sf;

	/*
	 * //Using cunstructor (2nd way) public CustomerDao(SessionFactory sf) {
	 * super(); this.sf = sf; }
	 */
	
	public String insertCustomer(Customer customer ) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		//if we need to do insert,update,delete -> have to use Transaction
		
		session.save(customer);
		tr.commit();
		session.close();
		
		return "Customer Inserted Successfully";
		}
	
	public List<Customer> getCustomerList() {
		
		Session session = sf.openSession();	
		return session.createQuery("From Customer").list();
	}
	
	public Customer getCustomerById(int id) {
		Session session = sf.openSession();
		
	 // when we use get, it will return null if obeject not found. but
	//  when we use load, it will return objectNotfound exception .
		return session.get(Customer.class, id);
	}
	
	
	public String updateCustomers(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();
		
		return "Customer Updated Succsessfully";
    }
	 
	public String deletecustomerById(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customerr = session.get(Customer.class, id); 
		session.delete(customerr);
		tr.commit();
		session.close();
		return "Customer Deleted Successfully";
	}
	
	public String insertMultipleCustomer(List<Customer> customers) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		//use foreach when adding List of customers
		for(Customer customer : customers) {
			session.save(customer);
		}
		tr.commit();
		session.close();
		return "Customer inserted successfully";
	}
	
	
	public List<Customer> getCustomersByFirstName(String FName){
		Session session = sf.openSession();
	Query<Customer> customers =	session.createQuery("from Customer c where c.firstname =: firstname" , Customer.class);
	customers.setParameter("firstname", FName);
	List<Customer> list = customers.list();	
	
	return list;
	}
	
	
	public List<Customer> getCustomersByLessThanAge(int Age){
		
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.age<:age", Customer.class);
		customers.setParameter("age", Age);
		return customers.list();
		
		
	}
	
	public String updateFirstName(int id, String firstName) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setFirstname(firstName);
		tr.commit();
		session.close();
		return "Updated successfully";
	}
	
	
	
	
	
	
	
	

}
