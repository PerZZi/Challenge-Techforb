package com.example.REST.Countries.controllers;

import com.example.REST.Countries.dtos.AlertaResponse;
import com.example.REST.Countries.dtos.LecturaResponse;
import com.example.REST.Countries.dtos.SensorCreate;
import com.example.REST.Countries.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/lecturasList")
    public List<LecturaResponse> getAllLecturas(){
        return sensorService.getAllLecturasDTO();
    }

    @GetMapping("/alertasList")
    public List<AlertaResponse> getAllAlertas(){
        return sensorService.getAllAlertasDTO();
    }

    @PostMapping("/create")
    public ResponseEntity<String> sensorCreate(@RequestBody SensorCreate sensorCreate){
        return sensorService.createSensor(sensorCreate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSensor(@RequestBody SensorCreate sensorCreate, @RequestParam Long id){
        return sensorService.updateSensor(sensorCreate,id);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> deleteSensor(@PathVariable Long id){
        return sensorService.deleteSensor(id);
    }
}
