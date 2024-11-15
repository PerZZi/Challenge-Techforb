package com.example.REST.Countries.models;

import com.example.REST.Countries.models.enums.TipoAlerta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoAlerta tipoAlerta;
    private String description;
    private LocalDateTime fecha_hora;
    @ManyToOne
    private Sensor sensor;
    @ManyToOne
    private Planta planta;

    public Alerta(TipoAlerta tipoAlerta, String description, LocalDateTime fecha_hora) {
        this.tipoAlerta = tipoAlerta;
        this.description = description;
        this.fecha_hora = fecha_hora;
    }
}
