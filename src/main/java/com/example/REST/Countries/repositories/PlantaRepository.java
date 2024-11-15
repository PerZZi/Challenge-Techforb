package com.example.REST.Countries.repositories;

import com.example.REST.Countries.models.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {

    Planta findByName(String name);
    boolean existsByName(String name);
}
