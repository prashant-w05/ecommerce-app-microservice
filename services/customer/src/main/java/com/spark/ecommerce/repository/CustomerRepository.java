package com.spark.ecommerce.repository;

import com.spark.ecommerce.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
