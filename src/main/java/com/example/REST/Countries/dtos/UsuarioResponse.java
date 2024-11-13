package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.enums.Rol;
import lombok.Getter;

@Getter
public class UsuarioResponse {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Rol rol;
}
