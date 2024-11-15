package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.enums.SensorType;
import com.example.REST.Countries.models.enums.State;
import lombok.Getter;

@Getter
public class SensorCreate {

    private String name;
    private State state;
    private SensorType sensorType;
}
