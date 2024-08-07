package com.spring_boot.Servicio;

import com.spring_boot.Entidad.Factura;
import com.spring_boot.Entidad.Producto;
import com.spring_boot.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicio {
    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Producto> buscarProductosByFactura(Long numeroFactura){
        return facturaRepositorio.findByNumeroFactura(numeroFactura).stream()
                .map(Factura::getProducto)
                .collect(Collectors.toList());
    }



}
