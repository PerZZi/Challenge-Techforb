package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.Sensor;
import com.example.REST.Countries.models.enums.SensorType;
import com.example.REST.Countries.models.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SensorResponse {

    private Long id;
    private String name;
    private State state;
    private SensorType sensorType;

    public SensorResponse(Sensor sensor) {
        id = sensor.getId();
        name = sensor.getName();
        state = sensor.getState();
        sensorType = sensor.getSensorType();
    }
}
