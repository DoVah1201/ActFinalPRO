package com.actfinal.ut7.src.main.java.com.actfinal.ut7.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notas")
public class Nota {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@JoinColumn(name = "usuario_id", nullable = false)

private String titulo;


private String contenido;


private LocalDateTime fechaCreacion;

}
