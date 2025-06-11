package com.actfinal.ut7.src.main.java.com.actfinal.ut7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.service.NotaService;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public ResponseEntity<List<Nota>> getAllNotas() {
        List<Nota> notas = notaService.getAll();
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        return notaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Nota>> getNotasByUsuario(
            @PathVariable Long usuarioId,
            @RequestParam(defaultValue = "asc") String order) {
        
        List<Nota> notas = notaService.findByUsuarioId(usuarioId, order);
        return ResponseEntity.ok(notas);
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@Validated @RequestBody Nota nota) {
        Nota nuevaNota = notaService.save(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(
            @PathVariable Long id,
            @Validated @RequestBody Nota nota) {
        
        Nota notaActualizada = notaService.update(id, nota);
        return ResponseEntity.ok(notaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        notaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}