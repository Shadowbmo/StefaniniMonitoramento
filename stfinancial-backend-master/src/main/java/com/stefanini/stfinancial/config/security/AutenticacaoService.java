package com.stefanini.stfinancial.config.security;

import com.stefanini.stfinancial.model.Usuario;
import com.stefanini.stfinancial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = repository.findByNome(username);
        if(user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException("Dados inválidos");
    }
}
