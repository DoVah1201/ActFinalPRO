package com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    Optional<Nota> findByTitulo(String titulo);

    Optional<Nota> findByContenido(String contenido);

    List<Nota> findByUsuarioId(Long usuarioId, Sort sort);

}
