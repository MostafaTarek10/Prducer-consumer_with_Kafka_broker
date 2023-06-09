package com.springbootrest.service;

import com.springbootrest.model.Customer;
import com.springbootrest.model.dto.CustomerDto;
import com.springbootrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper ;
    }

    public void persistOffer(CustomerDto customerDto){
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer persistCustomer = customerRepository.save(customer);

    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    }
