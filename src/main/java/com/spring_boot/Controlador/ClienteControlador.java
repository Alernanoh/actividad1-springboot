package com.spring_boot.Controlador;

import com.spring_boot.Entidad.Cliente;
import com.spring_boot.Entidad.Producto;
import com.spring_boot.Servicio.ClienteServicio;
import com.spring_boot.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/clientes")
    public String mostrarClientes(@RequestParam(name="buscarCliente", required = false, defaultValue= "") String buscarCliente, Model model) {
        List<Cliente> clientes = clienteServicio.buscarClienteNombre(buscarCliente);
        model.addAttribute("clientes", clientes);
        return "Cliente/vistaClientes";
    }

    @GetMapping("/formularioCliente")
    public String formularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/formularioCliente";
    }

    @PostMapping("/guardar/cliente")
    public String crearCliente(Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/cliente/{id}")
    public String editarCliente(Model model, @PathVariable Long id) {
        Optional<Cliente> cliente = clienteServicio.buscarClienteId(id);
        model.addAttribute("cliente", cliente.orElse(new Cliente()));
        return "Cliente/formularioCliente";
    }

//    @GetMapping("/productos/{clienteId}")
//    public String mostrarProductosByCliente(@PathVariable Long clienteId, Model model) {
//        List<Producto> productos = clienteServicio.buscarProductoByClienteId(clienteId);
//        model.addAttribute("productos", productos);
//        return "Cliente/productos";
//    }
}
