package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlantaResponse {

    private Long id;
    private String name;
    private String location;
    private State state;
}
