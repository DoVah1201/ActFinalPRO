package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.NotaRepository;


public abstract class AbstractNotaService extends AbstractCrudService<Nota, Long> implements NotaService {

    private final NotaRepository notaRepository;

    
    public AbstractNotaService(NotaRepository notaRepository) {
        super(notaRepository);
        this.notaRepository = notaRepository;
    }

    
     @Override
    public List<Nota> findByUsuarioId(Long usuarioId, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by("fechaCreacion").descending()
                                                   : Sort.by("fechaCreacion").ascending();
        return notaRepository.findByUsuarioId(usuarioId, sort);
    }
}