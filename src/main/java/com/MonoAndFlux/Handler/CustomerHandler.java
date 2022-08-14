package com.MonoAndFlux.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.MonoAndFlux.Dao.CustomerDao;
import com.MonoAndFlux.Dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	@Autowired
	private CustomerDao customerDao;
	
	public Mono<ServerResponse> loadCustomers(ServerRequest request){
		Flux<Customer> customers= customerDao.getAllCustomers();
		return ServerResponse.ok().body(customers,Customer.class);
	}
}
