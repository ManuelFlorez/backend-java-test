package com.api.rest.controller;

import com.api.rest.repository.Customer;
import com.api.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomer(
            @RequestParam(required = true) String typeDocument, @RequestParam(required = true) String document) {
        try {
            Customer customer = customerService.getCustomer(typeDocument, document);
            return customer != null ?
                    new ResponseEntity<>(customer, HttpStatus.OK):
                    new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer customerResult = customerService.createCustomer(customer);
            return customerResult != null ?
                    new ResponseEntity<>(customerResult, HttpStatus.OK):
                    new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        try {
            Customer customerResult = customerService.updateCustomer(id, customer);
            return customerResult != null ?
                    new ResponseEntity<>(customerResult, HttpStatus.OK):
                    new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        try {
            boolean success = customerService.deleteCustomer(id);
            return success ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
