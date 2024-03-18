package com.api.rest.service;

import com.api.rest.service.data.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaludoService2 {

    @Autowired
    private RestTemplate restTemplate;

    public Greeting saludo(String name) {
        return restTemplate.getForObject("http://localhost:8080/api/hola?name=" + name, Greeting.class);
    }

}
