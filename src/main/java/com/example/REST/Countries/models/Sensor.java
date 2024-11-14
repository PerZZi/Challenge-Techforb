package com.example.REST.Countries.models;

import com.example.REST.Countries.models.enums.SensorType;
import com.example.REST.Countries.models.enums.State;
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
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;
    @Enumerated(EnumType.STRING)
    private SensorType sensorType;
    @ManyToOne
    private Planta planta;


    public Sensor(String name, State state, SensorType sensorType) {
        this.name = name;
        this.state = state;
        this.sensorType = sensorType;
    }
}
