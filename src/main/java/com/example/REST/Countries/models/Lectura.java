package com.example.REST.Countries.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valor;
    private String unidad;
    @ManyToOne
    private Sensor sensor;


    public Lectura(Float valor, String unidad, Sensor sensor) {
        this.valor = valor;
        this.unidad = unidad;
        this.sensor = sensor;
    }
}
