package com.actfinal.ut7.src.main.java.com.actfinal.ut7.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.springframework.http.HttpStatus;


import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Nota;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.model.Usuario;
import com.actfinal.ut7.src.main.java.com.actfinal.ut7.service.NotaService;



@RestController
@RequestMapping("/api/v1/notas")

public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<Nota> getNotas(@RequestParam(required = false) Long usuarioId,
                               @RequestParam(defaultValue = "asc") String order) {
        if (usuarioId != null) {
            return NotaService.findByUsuarioId(usuarioId, order);
        }
        return notaService.getAll();
    }

    @GetMapping("/{id}")
    public Nota getById(@PathVariable Long id) {
        return notaService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Nota createNota(@RequestParam Long usuarioId, @RequestBody Nota nota) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        nota.setUsuario(usuario);
        return notaService.save(nota);
    }

    @PutMapping("/{id}")
    public Nota update(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.update(id, nota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notaService.deleteById(id);
    }
}
