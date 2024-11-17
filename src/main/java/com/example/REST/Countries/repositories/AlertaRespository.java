package com.example.REST.Countries.repositories;

import com.example.REST.Countries.models.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRespository extends JpaRepository<Alerta, Long> {
}
