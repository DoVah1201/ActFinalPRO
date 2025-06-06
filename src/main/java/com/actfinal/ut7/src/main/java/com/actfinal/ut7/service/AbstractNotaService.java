package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import java.util.List;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.NotaRepository;


public abstract class AbstractNotaService extends AbstractCrudService<Nota, Long> {

    protected final NotaRepository notaRepository;

    
    public AbstractNotaService(NotaRepository notaRepository) {
        super(notaRepository);
        this.notaRepository = notaRepository;
    }

    
    public List<Nota> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        return notaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    
    public List<Nota> buscarPorContenido(String contenido) {
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido no puede estar vacío");
        }
        return notaRepository.findByContenidoContainingIgnoreCase(contenido);
    }
}