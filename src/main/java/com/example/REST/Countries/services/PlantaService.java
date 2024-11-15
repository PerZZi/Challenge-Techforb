package com.example.REST.Countries.services;

import com.example.REST.Countries.dtos.PlantaCreate;
import com.example.REST.Countries.models.Planta;
import org.springframework.http.ResponseEntity;

public interface PlantaService {

    Planta findByName(String name);
    boolean existsByName(String name);
    ResponseEntity<String> createPlanta(PlantaCreate plantaCreate);
    ResponseEntity<String> updatePlanta(PlantaCreate plantaCreate, String name);
    ResponseEntity<String> deletePlanta(Long id);
}
