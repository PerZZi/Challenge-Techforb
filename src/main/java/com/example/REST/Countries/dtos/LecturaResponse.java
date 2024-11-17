package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.Lectura;
import com.example.REST.Countries.models.Sensor;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LecturaResponse {

    private Long id;
    private Float valor;
    private String unidad;
    private Sensor sensor;

    public LecturaResponse(Lectura lectura) {
        id = lectura.getId();
        valor = lectura.getValor();
        unidad = lectura.getUnidad();
        sensor = lectura.getSensor();
    }
}
