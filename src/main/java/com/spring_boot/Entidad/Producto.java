package com.spring_boot.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    private int stock;

    private String descripcion;

    @OneToOne
    @JoinColumn(name = "garantia_id")
    private Garantia garantia;

    @OneToMany(mappedBy = "producto")
    List<Factura> facturas;



}
