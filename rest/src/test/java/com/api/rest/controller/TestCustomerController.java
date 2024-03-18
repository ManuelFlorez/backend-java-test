package com.api.rest.controller;

import com.api.rest.repository.Customer;
import com.api.rest.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TestCustomerController {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

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
    void createCustomerAPI() throws Exception {

        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> responseEntity = customerController.createCustomer(customer);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getId()).isEqualTo(1);
    }

    @Test
    void getCustomerAPI() throws Exception {

        when(customerService.getCustomer("C", "1090471388")).thenReturn(customer);

        ResponseEntity<Customer> responseEntity = customerController.getCustomer("C", "1090471388");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getId()).isEqualTo(1);
    }

    @Test
    void updateCustomerAPI() throws Exception {

        Customer customerUpdate = new Customer(1,
                "Felipe",
                "Dani",
                "Florez",
                "Archila",
                "3043742691",
                "Calle 23",
                "CUCUTA",
                "C",
                "1090471388");

        when(customerService.updateCustomer(1, customerUpdate)).thenReturn(customer);

        ResponseEntity<Customer> responseEntity = customerController.updateCustomer(1, customerUpdate);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getFirstName()).isEqualTo("Manuel");
        assertThat(responseEntity.getBody().getSecondName()).isEqualTo("Joaquin");
    }

    @Test
    void deleteCustomerAPI() throws Exception {

        when(customerService.deleteCustomer(1)).thenReturn(true);

        ResponseEntity<HttpStatus> responseEntity = customerController.deleteCustomer(1);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}
