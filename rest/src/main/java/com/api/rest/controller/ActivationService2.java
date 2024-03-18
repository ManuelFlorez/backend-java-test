package com.api.rest.controller;

import com.api.rest.service.SaludoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivationService2 {

    @Autowired
    private SaludoService2 saludoService2;

    @GetMapping(value = "/api/saludo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(saludoService2.saludo(name).greeting());
    }

}
