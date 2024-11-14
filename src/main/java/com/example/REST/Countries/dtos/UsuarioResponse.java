package com.example.REST.Countries.dtos;

import com.example.REST.Countries.models.Usuario;
import com.example.REST.Countries.models.enums.Rol;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Rol rol;

    public UsuarioResponse(Usuario usuario) {
        id = usuario.getId();
        name = usuario.getName();
        lastName = usuario.getLastName();
        email = usuario.getEmail();
        rol = usuario.getRol();
    }
}
