package com.MonoAndFlux.Dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.MonoAndFlux.Dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	private void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getAll(){
		return IntStream.rangeClosed(1,50)
				.peek(i -> sleepExecution(i))
				.peek(i -> System.out.println(i))
				.mapToObj(i->new Customer(i,"customer"+i))
				.collect(Collectors.toList());
	}
	
	public Flux<Customer> getAllStream(){
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println(i))
				.map(i->new Customer(i,"customer"+i));
	}
	
	public Flux<Customer> getAllCustomers(){
		return Flux.range(1, 50)
				.doOnNext(i -> System.out.println(i))
				.map(i->new Customer(i,"customer"+i));
	}
}
