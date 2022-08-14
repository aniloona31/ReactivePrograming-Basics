package com.MonoAndFlux.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MonoAndFlux.Dao.CustomerDao;
import com.MonoAndFlux.Dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getAllCustomers(){
		long start = System.currentTimeMillis();
		
		List<Customer> customers = customerDao.getAll();
		
		long end = System.currentTimeMillis();
		
		System.out.println(start);
		System.out.println(end);
		
		return customers;
	}
	
	public Flux<Customer> getAllCustomersStream(){
		long start = System.currentTimeMillis();
		
		Flux<Customer> customers = customerDao.getAllStream();
		
		long end = System.currentTimeMillis();
		
		System.out.println(start);
		System.out.println(end);
		
		return customers;
	}
}
