package com.spring_boot.Controlador;

import com.spring_boot.Entidad.Producto;
import com.spring_boot.Repositorio.ProductoRepositorio;
import com.spring_boot.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    //LEER
    @GetMapping("/productos")
    public String mostrarProductos(@RequestParam(name = "buscarProducto", required = false, defaultValue = "") String buscarProducto, Model model){
        List<Producto> productos = productoServicio.buscarProductoNombre(buscarProducto);
        model.addAttribute("buscarProducto", buscarProducto);
        model.addAttribute("productos", productos);
        return "/Producto/vistaProductos";
    }

    //CREAR
    @GetMapping("/formulario")
    public String formularioProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "/Producto/formularioProducto";
    }

    @PostMapping("/guardar/producto")
    public String crearProducto(Producto producto){
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    //ACTUALIZAR
    @GetMapping("/editar/producto/{id}")
    public String editarProducto(@PathVariable Long id, Model model){
        Optional<Producto> producto= productoServicio.buscarProductoId(id);
        model.addAttribute("producto", producto);
        return "/Producto/formularioProducto";
    }

    //ELIMINAR
    @GetMapping("/eliminar/producto/{id}")
    public String borrarProducto(@PathVariable Long id){
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }

}
