package com.api.rest.service;

import com.api.rest.repository.Customer;
import com.api.rest.repository.CustomerRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TestCustomerService {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    Customer customer = new Customer(1,
            "Manuel",
            "Joaquin",
            "Florez",
            "Archila",
            "3043742691",
            "Calle 23",
            "CUCUTA",
            "C",
            "1090471388");

    @Test
    void getCustomer() {
        when(customerRepository.findByDocument(any(String.class))).thenReturn(customer);
        Customer customerResult = customerService.getCustomer("C", "1090471388");
        assertThat(customerResult.getId()).isEqualTo(1);
    }

    @Test
    void createCustomer() {
        when(customerRepository.findByDocument(any(String.class))).thenReturn(null);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer customerResult = customerService.createCustomer(customer);
        assertThat(customerResult.getId()).isEqualTo(1);
    }

    @Test
    void updateCustomer() {
        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer customerResult = customerService.updateCustomer(1, customer);
        assertThat(customerResult.getId()).isEqualTo(1);
    }

    @Test
    void deleteCustomer() {
        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.of(customer));
        boolean result = customerService.deleteCustomer(1);
    }

}
