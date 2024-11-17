package com.example.REST.Countries.services.implement;

import com.example.REST.Countries.dtos.AlertaResponse;
import com.example.REST.Countries.dtos.LecturaResponse;
import com.example.REST.Countries.dtos.SensorCreate;
import com.example.REST.Countries.dtos.SensorResponse;
import com.example.REST.Countries.models.Alerta;
import com.example.REST.Countries.models.Lectura;
import com.example.REST.Countries.models.Sensor;
import com.example.REST.Countries.models.enums.State;
import com.example.REST.Countries.repositories.AlertaRespository;
import com.example.REST.Countries.repositories.LecturaRespository;
import com.example.REST.Countries.repositories.SensorRepository;
import com.example.REST.Countries.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorServiceImplement implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private LecturaRespository lecturaRespository;

    @Autowired
    private AlertaRespository alertaRespository;

    @Override
    public Sensor findById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lectura> getAllLecturas() {
        return lecturaRespository.findAll();
    }

    @Override
    public List<LecturaResponse> getAllLecturasDTO() {
        return getAllLecturas().stream().map(LecturaResponse ::new).collect(Collectors.toList());
    }

    @Override
    public List<Alerta> getAllAlertas() {
        return alertaRespository.findAll();
    }

    @Override
    public List<AlertaResponse> getAllAlertasDTO() {
        return getAllAlertas().stream().map(AlertaResponse::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> createSensor(SensorCreate sensorCreate) {

        if(sensorCreate.getName() == null || sensorCreate.getName().isBlank()){
            return new ResponseEntity<>("El nombre del sensor no puede estar vacio", HttpStatus.BAD_REQUEST);
        }

        if(sensorCreate.getState() == null){
            return new ResponseEntity<>("El estado de sensor no puede estar vacio o nulo", HttpStatus.BAD_REQUEST);
        }

        if(sensorCreate.getSensorType() == null){
            return new ResponseEntity<>("El tipo de sensor no puede estar vacio o nulo", HttpStatus.BAD_REQUEST);
        }

        Sensor sensor = new Sensor(sensorCreate.getName(),sensorCreate.getState(),sensorCreate.getSensorType());

        sensorRepository.save(sensor);

        return new ResponseEntity<>("Se creo correctamente el sensor", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateSensor(SensorCreate sensorCreate, Long id) {

        Sensor sensor = sensorRepository.findById(id).orElse(null);

        if(sensor == null){
            return new ResponseEntity<>("No se encontro el sensor que busca",HttpStatus.NOT_FOUND);
        }

        sensor.setName(sensorCreate.getName());
        sensor.setState(sensorCreate.getState());
        sensor.setSensorType(sensorCreate.getSensorType());

        sensorRepository.save(sensor);

        return new ResponseEntity<>("Se modifico el sensor correctamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteSensor(Long id) {

        Sensor sensor = sensorRepository.findById(id).orElse(null);

        if(sensor == null){
            return new ResponseEntity<>("No se encontro el sensor que desea eliminar",HttpStatus.NOT_FOUND);
        }

        sensor.setState(State.DISABLE);

        sensorRepository.save(sensor);

        return new ResponseEntity<>("Se elimino correctamente el sensor", HttpStatus.OK);
    }


}
