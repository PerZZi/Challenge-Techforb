package com.example.REST.Countries.services;

import com.example.REST.Countries.dtos.UsuarioRegister;
import com.example.REST.Countries.dtos.UsuarioResponse;
import com.example.REST.Countries.models.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    Usuario findByEmail(String email);
    Usuario findById(Long id);
    UsuarioResponse getUser(Long id);
    boolean existsByEmail(String email);
    ResponseEntity<String> registerUsers(UsuarioRegister usuarioRegister);
}
