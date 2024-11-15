package com.example.REST.Countries.services;

import com.example.REST.Countries.dtos.SensorCreate;
import com.example.REST.Countries.models.Sensor;
import org.springframework.http.ResponseEntity;

public interface SensorService {

    Sensor findById(Long id);
    ResponseEntity<String> createSensor(SensorCreate sensorCreate);
    ResponseEntity<String> updateSensor(SensorCreate sensorCreate, Long id);
    ResponseEntity<String> deleteSensor(Long id);
}
