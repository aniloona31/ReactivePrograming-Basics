package com.MonoAndFlux;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
	
	@Test
	public void testMono() {
		//creating object of type mono
		//we can pass any data type to mono
		//mono and flux will act as publisheer as we can see from their internal implementation
		//mono creates objet mono of only one argument
		List<String> list = new ArrayList<String>();
		list.add("anirudh");
		list.add("yooy");
		Mono<List<String>> firstMono = Mono.just(list).log();
		
		//subscriber needs to call the subscribe() method of publisher
		//subscribe is an overloaded method
		firstMono.subscribe(System.out::println);
	}
	
	@Test
	public void testFlux() {
		//flux can create object of multiple arguments and call onNext() method each time
		//new data comes from publisher to subscribber
		Flux<String> firstFlux = Flux.just("spring","springboot","microservices")
				.concatWithValues("aws")
				.log();
		
		firstFlux.subscribe(System.out::println);
	}
}
