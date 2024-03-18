package com.api.restSecond.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping(value = "/api/hola", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> hello(@RequestParam(value = "name") String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("greeting", String.format("Hello %s!", name));
        return map;
    }

}
