package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Usuario;


public interface UsuarioService extends CrudService<Usuario, Long> {
    Usuario signIn(String email, String password);
}