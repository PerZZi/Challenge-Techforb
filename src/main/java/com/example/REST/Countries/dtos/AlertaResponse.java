package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.Alerta;
import com.example.REST.Countries.models.Planta;
import com.example.REST.Countries.models.Sensor;
import com.example.REST.Countries.models.enums.TipoAlerta;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class AlertaResponse {

    private Long id;
    private TipoAlerta tipoAlerta;
    private String description;
    private LocalDateTime fecha_hora;
    private Sensor sensor;
    private Planta planta;

    public AlertaResponse(Alerta alerta) {
        id = alerta.getId();
        tipoAlerta = alerta.getTipoAlerta();
        description = alerta.getDescription();
        fecha_hora = alerta.getFecha_hora();
        sensor = alerta.getSensor();
        planta = alerta.getPlanta();
    }
}
