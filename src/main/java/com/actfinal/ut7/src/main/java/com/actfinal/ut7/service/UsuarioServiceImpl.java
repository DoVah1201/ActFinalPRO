package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Usuario;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.UsuarioRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class UsuarioServiceImpl extends AbstractCrudService<Usuario, Long> implements UsuarioService {

     private final UsuarioRepository usuarioRepository;

     public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
        this.usuarioRepository = repository;
    }

    @Override
    public Usuario signIn(String email, String password) {
        return usuarioRepository.findByEmail(email)
                .filter(u -> u.getPasswordHash().equals(password)) 
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas"));
    }
}