package com.yiii.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getString")
    public String getString() {
        String url ="http://localhost:8081/api/provider/getString";
        String jsonpObject= restTemplate.getForObject(url, String.class);

        return  jsonpObject;

    }



}
