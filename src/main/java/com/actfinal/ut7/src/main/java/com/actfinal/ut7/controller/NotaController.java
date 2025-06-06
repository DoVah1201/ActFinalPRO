package com.actfinal.ut7.src.main.java.com.actfinal.ut7.controller;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.service.AbstractNotaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final AbstractNotaService AbstractNotaService;

    
    public NotaController(AbstractNotaService AbstractNotaService) {
        this.AbstractNotaService = AbstractNotaService;
    }

    
    @GetMapping
    public ResponseEntity<List<Nota>> obtenerTodas() {
        return ResponseEntity.ok(AbstractNotaService.getAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerPorId(@PathVariable Long id) {
        return AbstractNotaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Nota> crear(@RequestBody Nota nota) {
        return ResponseEntity.ok(AbstractNotaService.save(nota));
    }

    
    @GetMapping("/buscar")
    public ResponseEntity<List<Nota>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(AbstractNotaService.buscarPorTitulo(titulo));
    }
}