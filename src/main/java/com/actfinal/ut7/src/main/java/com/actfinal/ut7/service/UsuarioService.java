package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import org.springframework.stereotype.Service;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    
}
