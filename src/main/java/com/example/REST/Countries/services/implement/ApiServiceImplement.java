package com.example.REST.Countries.services.implement;

import com.example.REST.Countries.dtos.CountryDTO;
import com.example.REST.Countries.services.ApiService;
import com.example.REST.Countries.utils.CountryNotFoundException;
import com.example.REST.Countries.utils.CountryExceptionData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ApiServiceImplement implements ApiService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CountryDTO[] getAllCountries() {

        String url = "https://restcountries.com/v3.1/all";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new CountryNotFoundException("Error al encontrar paises" + response.getStatusCode());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(response.getBody(), CountryDTO[].class);
        } catch (Exception e) {
            throw new CountryExceptionData("Hubo un error al cargar la data", e);
        }
    }

}
