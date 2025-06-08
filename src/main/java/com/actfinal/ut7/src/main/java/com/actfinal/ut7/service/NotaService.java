package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;


import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;


import java.util.List;

public interface NotaService extends CrudService<Nota, Long> {
    static List<Nota> findByUsuarioId(Long usuarioId, String order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsuarioId'");
    }
}
