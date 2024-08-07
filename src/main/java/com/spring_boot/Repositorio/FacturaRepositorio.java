package com.spring_boot.Repositorio;

import com.spring_boot.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    List<Factura> findByNumeroFactura(Long numeroFactura);
}
