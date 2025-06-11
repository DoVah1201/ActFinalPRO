package com.actfinal.ut7.src.main.java.com.actfinal.ut7.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.repository.NotaRepository;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.service.NotaService;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.service.NotaServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public NotaService notaService(NotaRepository notaRepository) {
        return new NotaServiceImpl(notaRepository);
    }
}