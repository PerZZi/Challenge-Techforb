package com.example.REST.Countries.models;

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
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;
    @OneToMany(mappedBy = "planta", fetch = FetchType.EAGER)
    private List<Sensor> sensorList = new ArrayList<>();


    public Planta(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addSensor(Sensor sensor){
        sensor.setPlanta(this);
        sensorList.add(sensor);
    }
}
