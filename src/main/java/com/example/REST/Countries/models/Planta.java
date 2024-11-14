package com.example.REST.Countries.models;

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
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;


    public Planta(String name, String location, State state) {
        this.name = name;
        this.location = location;
        this.state = state;
    }
}
