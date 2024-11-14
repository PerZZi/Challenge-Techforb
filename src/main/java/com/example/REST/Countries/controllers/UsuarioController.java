package com.example.REST.Countries.controllers;

import com.example.REST.Countries.dtos.UsuarioRegister;
import com.example.REST.Countries.dtos.UsuarioResponse;
import com.example.REST.Countries.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/profile")
    public UsuarioResponse getProfile(@PathVariable Long id){
        return usuarioService.getUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioRegister usuarioRegister){
        return usuarioService.registerUsers(usuarioRegister);
    }
}
