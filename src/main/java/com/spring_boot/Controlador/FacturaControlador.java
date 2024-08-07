package com.spring_boot.Controlador;

import com.spring_boot.Entidad.Producto;
import com.spring_boot.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class FacturaControlador {
    @Autowired
    private FacturaServicio facturaServicio;
    @GetMapping("/facturas")
    public String buscarProductosByFactura(@RequestParam(value = "numeroFactura", required = false) Long numeroFactura, Model model){
        if(numeroFactura!=null){
            List<Producto> productos = facturaServicio.buscarProductosByFactura(numeroFactura);
            model.addAttribute("productos", productos);
        }
        return "Factura/vistaFactura";

    }

}
