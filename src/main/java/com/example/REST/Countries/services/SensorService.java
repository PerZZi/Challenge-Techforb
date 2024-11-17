package com.example.REST.Countries.services;

import com.example.REST.Countries.dtos.AlertaResponse;
import com.example.REST.Countries.dtos.LecturaResponse;
import com.example.REST.Countries.dtos.SensorCreate;
import com.example.REST.Countries.models.Alerta;
import com.example.REST.Countries.models.Lectura;
import com.example.REST.Countries.models.Sensor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorService {

    Sensor findById(Long id);
    List<Lectura> getAllLecturas();
    List<LecturaResponse> getAllLecturasDTO();
    List<Alerta> getAllAlertas();
    List<AlertaResponse> getAllAlertasDTO();
    ResponseEntity<String> createSensor(SensorCreate sensorCreate);
    ResponseEntity<String> updateSensor(SensorCreate sensorCreate, Long id);
    ResponseEntity<String> deleteSensor(Long id);
}
