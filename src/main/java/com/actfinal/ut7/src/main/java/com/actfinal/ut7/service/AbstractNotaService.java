package com.actfinal.ut7.src.main.java.com.actfinal.ut7.service;

import org.springframework.data.jpa.repository.JpaRepository;



import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.NotaRepository;

public abstract class AbstractNotaService extends AbstractCrudService<Nota, NotaRepository> {

    public AbstractNotaService(JpaRepository<Nota, NotaRepository> repo) {
        super(repo);
        
    }

    

    

}
