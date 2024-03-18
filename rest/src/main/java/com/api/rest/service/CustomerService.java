package com.api.rest.service;

import com.api.rest.repository.Customer;
import com.api.rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String typeDocument, String document) {
        Customer customer = customerRepository.findByDocument(document);
        if(nonNull(customer) && nonNull(customer.getTypeDocument()) && customer.getTypeDocument().equals(typeDocument)) {
            return customer;
        }

        return null;
    }

    public Customer createCustomer(Customer customer) {

        Customer customerResult = getCustomer(customer.getTypeDocument(), customer.getDocument());
        if(customerResult != null) {
            return null;
        }

        return customerRepository.save(new Customer(0,
                customer.getFirstName(),
                customer.getSecondName(),
                customer.getLastname(),
                customer.getSecondLastname(),
                customer.getTelephone(),
                customer.getAddress(),
                customer.getCityOfResidence(),
                customer.getTypeDocument(),
                customer.getDocument()
                ));

    }

    public Customer updateCustomer(long id, Customer customer) {
        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setFirstName(customer.getFirstName());
            _customer.setSecondName(customer.getSecondName());
            _customer.setLastname(customer.getLastname());
            _customer.setSecondLastname(customer.getSecondLastname());
            _customer.setTelephone(customer.getTelephone());
            _customer.setAddress(customer.getAddress());
            _customer.setCityOfResidence(customer.getCityOfResidence());
            _customer.setTypeDocument(customer.getTypeDocument());
            _customer.setDocument(customer.getDocument());
            return customerRepository.save(_customer);
        }
        return null;
    }

    public boolean deleteCustomer(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
