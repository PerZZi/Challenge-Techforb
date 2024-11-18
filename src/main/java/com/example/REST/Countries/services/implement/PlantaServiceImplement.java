package com.example.REST.Countries.services.implement;

import com.example.REST.Countries.dtos.PlantaCreate;
import com.example.REST.Countries.models.Planta;
import com.example.REST.Countries.models.enums.State;
import com.example.REST.Countries.repositories.PlantaRepository;
import com.example.REST.Countries.services.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlantaServiceImplement implements PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;
    @Override
    public Planta findByName(String name) {
        return plantaRepository.findByName(name);
    }

    @Override
    public Planta findById(Long id) {
        return plantaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsByName(String name) {
        return plantaRepository.existsByName(name);
    }

    @Override
    public ResponseEntity<String> createPlanta(PlantaCreate plantaCreate) {

        if(plantaCreate.getName() == null || plantaCreate.getName().isBlank()){
            return new ResponseEntity<>("El nombre de planta no puede estar vacio", HttpStatus.BAD_REQUEST);
        }

        if(plantaCreate.getLocation() == null || plantaCreate.getLocation().isBlank()){
            return new ResponseEntity<>("La localizacion no puede estar vacia", HttpStatus.BAD_REQUEST);
        }

        if(existsByName(plantaCreate.getName())){
            return new ResponseEntity<>("La planta ya existe", HttpStatus.BAD_REQUEST);
        }

        Planta planta = new Planta(plantaCreate.getName(),plantaCreate.getLocation());

        plantaRepository.save(planta);

        return new ResponseEntity<>("Se creo la planta correctamente", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updatePlanta(PlantaCreate plantaCreate, String name) {

        Planta planta = plantaRepository.findByName(name);

        if(planta == null){
            return new ResponseEntity<>("La planta que busca no existe", HttpStatus.NOT_FOUND);
        }

        planta.setName(plantaCreate.getName());
        planta.setLocation(plantaCreate.getLocation());

        plantaRepository.save(planta);

        return new ResponseEntity<>("Se modifico la planta con exito", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deletePlanta(Long id) {

        Planta planta = plantaRepository.findById(id).orElse(null);

        if(planta == null){
            return new ResponseEntity<>("La planta con ese id no existe", HttpStatus.NOT_FOUND);
        }

        if(planta.getState() != State.ACTIVE){
            return new ResponseEntity<>("La planta ya esta desabilitada", HttpStatus.BAD_REQUEST);
        }

        planta.setState(State.DISABLE);

        plantaRepository.save(planta);

        return new ResponseEntity<>("Se elimino correctamente esta planta", HttpStatus.OK);
    }
}
