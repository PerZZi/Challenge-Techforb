package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.enums.SensorType;
import com.example.REST.Countries.models.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SensorResponse {

    private Long id;
    private String name;
    private State state;
    private SensorType sensorType;
}
