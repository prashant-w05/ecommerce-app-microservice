package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.CustomerRequest;
import com.spark.ecommerce.dto.CustomerResponse;
import java.util.List;

public interface ICustomerService {

    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomer(String customerId);
}
