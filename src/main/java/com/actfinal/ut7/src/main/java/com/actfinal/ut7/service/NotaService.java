package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;


import java.util.List;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;

public interface NotaService extends CrudService<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId, String order);
}
