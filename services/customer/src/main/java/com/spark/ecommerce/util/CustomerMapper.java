package com.spark.ecommerce.util;

import com.spark.ecommerce.dto.CustomerRequest;
import com.spark.ecommerce.dto.CustomerResponse;
import com.spark.ecommerce.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if(request == null){
            return null;
        }

        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
