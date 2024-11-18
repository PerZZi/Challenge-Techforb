package com.example.REST.Countries.config.jwt;

import com.example.REST.Countries.models.Usuario;
import com.example.REST.Countries.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);

        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }

        User.UserBuilder builder = User.withUsername(username);
        builder.password(usuario.getPassword());
        builder.roles("CLIENT");

        return builder.build();
    }
}
