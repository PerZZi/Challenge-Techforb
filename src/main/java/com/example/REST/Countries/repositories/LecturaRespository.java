package com.example.REST.Countries.repositories;

import com.example.REST.Countries.models.Lectura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturaRespository extends JpaRepository<Lectura,Long> {
}
