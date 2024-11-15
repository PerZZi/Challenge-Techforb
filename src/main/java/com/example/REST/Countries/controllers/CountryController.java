package com.example.REST.Countries.controllers;

import com.example.REST.Countries.dtos.CountryDTO;
import com.example.REST.Countries.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ApiService apiService;


    @GetMapping("/all")
    public ResponseEntity<CountryDTO[]> getAllCountries(){
        return ResponseEntity.ok(apiService.getAllCountries());
    }
}
