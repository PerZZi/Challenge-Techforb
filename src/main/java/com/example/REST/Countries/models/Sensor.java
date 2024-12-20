package com.example.REST.Countries.models;

import com.example.REST.Countries.models.enums.SensorType;
import com.example.REST.Countries.models.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<Lectura> lecturasList = new ArrayList<>();
    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<Alerta> alertaList = new ArrayList<>();


    public Sensor(String name, State state, SensorType sensorType) {
        this.name = name;
        this.state = state;
        this.sensorType = sensorType;
    }

    public void addLectura(Lectura lectura){
        lectura.setSensor(this);
        lecturasList.add(lectura);
    }

    public void addAlerta(Alerta alerta){
        alerta.setSensor(this);
        alertaList.add(alerta);
    }
}
