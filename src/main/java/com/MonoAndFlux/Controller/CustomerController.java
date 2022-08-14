package com.MonoAndFlux.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MonoAndFlux.Dto.Customer;
import com.MonoAndFlux.Service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	//produces tell that we are returning an even and not an entire object as we do in rest api
	@GetMapping(value = "/customers/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Customer>> getAllCustomersStream(){
		return new ResponseEntity<Flux<Customer>>(customerService.getAllCustomersStream(),HttpStatus.OK);
	}
	
}
