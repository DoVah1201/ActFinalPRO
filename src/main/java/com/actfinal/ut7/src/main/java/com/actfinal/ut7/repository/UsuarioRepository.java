package com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar un usuario por su email
    Optional<Usuario> findByEmail(String email);

    // Método para verificar si un usuario existe por su email
    boolean existeEmail(String email);

}