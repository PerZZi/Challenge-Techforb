package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.enums.State;
import lombok.Getter;

@Getter
public class PlantaCreate {

    private String name;
    private String location;
    private State state;
}
