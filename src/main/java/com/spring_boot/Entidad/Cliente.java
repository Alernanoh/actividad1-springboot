package com.spring_boot.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;



}
