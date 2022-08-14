package com.MonoAndFlux.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.MonoAndFlux.Entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,Integer>{

}
