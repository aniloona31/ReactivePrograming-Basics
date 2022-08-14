package com.MonoAndFlux.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.MonoAndFlux.Dao.CustomerDao;
import com.MonoAndFlux.Dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
	
	@Autowired
	private CustomerDao customerDao;
	
	public Mono<ServerResponse> getCustomers(ServerRequest request){
		Flux<Customer> customers = customerDao.getAllStream();
		System.out.println(request);
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customers, Customer.class);
	}
	
	
	public Mono<ServerResponse> getCustomer(ServerRequest request){
		//type casting string to integer.
		Integer id = Integer.valueOf(request.pathVariable("input"));
		Mono<Customer> customer = customerDao.getAllStream().filter(c -> c.getId() == id).next();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customer,Customer.class);
	}
	
	public Mono<ServerResponse> saveCustomer(ServerRequest request){
		//converting body to mono
		Mono<Customer> customerMono = request.bodyToMono(Customer.class);
		
		//returns mono of string
		Mono<String> customer = customerMono.map(dto -> dto.getId() + " : " + dto.getName());
		System.out.println(customer);
		return ServerResponse.ok()
				.body(customer, String.class);
	}
}
