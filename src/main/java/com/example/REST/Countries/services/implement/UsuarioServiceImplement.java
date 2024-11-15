package com.example.REST.Countries.services.implement;

import com.example.REST.Countries.dtos.UsuarioRegister;
import com.example.REST.Countries.dtos.UsuarioResponse;
import com.example.REST.Countries.models.Usuario;
import com.example.REST.Countries.repositories.UsuarioRepository;
import com.example.REST.Countries.services.UsuarioService;
import com.example.REST.Countries.utils.UserNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioResponse getUser(String email) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario == null){
            throw new UserNullException("Usuario con id " + email + " no encontrado.");
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        usuarioResponse.getId();
        usuarioResponse.getName();
        usuarioResponse.getLastName();
        usuarioResponse.getEmail();
        usuarioResponse.getRol();

        return usuarioResponse;
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public ResponseEntity<String> registerUsers(UsuarioRegister usuarioRegister) {


        if(existsByEmail(usuarioRegister.getEmail())){
            return new ResponseEntity<>("Ese emial ya esta en uso", HttpStatus.BAD_REQUEST);
        }

        if(usuarioRegister.getName().isBlank()){
            return new ResponseEntity<>("El nombre del usuario no puede estar vacio", HttpStatus.BAD_REQUEST);
        }

        if(usuarioRegister.getLastName().isBlank()){
            return new ResponseEntity<>("El apellido del usuario no puede estar vacio", HttpStatus.BAD_REQUEST);
        }

        if(usuarioRegister.getEmail().isBlank()){
            return new ResponseEntity<>("El email del usuario no puede estar vacio", HttpStatus.BAD_REQUEST);
        }

        if(usuarioRegister.getPassword().isBlank()){
            return new ResponseEntity<>("La contraseña del usuario no puede estar vacia", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(usuarioRegister.getName(),usuarioRegister.getLastName(),usuarioRegister.getEmail(),passwordEncoder.encode(usuarioRegister.getPassword()));

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Se registro correctamente al usuario", HttpStatus.CREATED);
    }

}
