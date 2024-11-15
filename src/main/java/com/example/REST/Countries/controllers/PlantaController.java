package com.example.REST.Countries.controllers;

import com.example.REST.Countries.dtos.PlantaCreate;
import com.example.REST.Countries.services.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planta")
public class PlantaController {

    @Autowired
    private PlantaService plantaService;

    @PostMapping("/create")
    public ResponseEntity<String> createPlanta(@RequestBody PlantaCreate plantaCreate){
        return plantaService.createPlanta(plantaCreate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePlanta(@RequestBody PlantaCreate plantaCreate, @RequestParam String name){
        return plantaService.updatePlanta(plantaCreate,name);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> deletePlanta(@PathVariable Long id){
        return plantaService.deletePlanta(id);
    }
}
