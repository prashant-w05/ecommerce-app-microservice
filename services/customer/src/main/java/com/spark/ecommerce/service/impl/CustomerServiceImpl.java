package com.spark.ecommerce.service.impl;

import com.spark.ecommerce.dto.CustomerRequest;
import com.spark.ecommerce.dto.CustomerResponse;
import com.spark.ecommerce.entity.Customer;
import com.spark.ecommerce.exception.CustomerNotFoundException;
import com.spark.ecommerce.repository.CustomerRepository;
import com.spark.ecommerce.service.ICustomerService;
import com.spark.ecommerce.util.CustomerMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerMapper mapper;

    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        System.out.println("Customer saved - "+customer.getId());
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {

        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                   String.format("Cannot update customer:: No customer found with the provided ID:: %s",request.id())
                ));

        mergeCustomer(customer, request);
        repository.save(customer);

    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID:: %s",customerId)
                ));
    }

    @Override
    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }

    public void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }

        if(StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }

        if(StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }

        if(request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}
