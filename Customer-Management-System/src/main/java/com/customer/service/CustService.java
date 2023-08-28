package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustReposiotry;


@Service
public class CustService {

	@Autowired
	private CustReposiotry custReposiotry;
	
	public void save(Customer c) {
		custReposiotry.save(c);
	}
	
	public List<Customer> getAllCustomer(){
		return custReposiotry.findAll();
	}
	public Customer getCustomerById(int id) {
		Optional<Customer> option=custReposiotry.findById(id);
		Customer customer=null;
		if(option.isPresent()) {
			customer=option.get();
		}
		else {
			throw new RuntimeException("Customer Not Found fro Id ::"+id);
		}

		return customer;
	}
	
	public void deleteCustomerById(int id) {
		custReposiotry.deleteById(id);
	}
}
