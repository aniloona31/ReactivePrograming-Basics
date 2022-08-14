package com.MonoAndFlux.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.MonoAndFlux.Handler.CustomerHandler;
import com.MonoAndFlux.Handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {
	
	@Autowired
	private CustomerHandler customerHandler;
	
	@Autowired
	private CustomerStreamHandler handler;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/router/customers",customerHandler::loadCustomers)
				.GET("/router/customers-stream",handler::getCustomers)
				.GET("/router/config/{input}",handler::getCustomer)
				.POST("/router/post",handler::saveCustomer) 
				.build();
	}
	
	
		 
	
}
