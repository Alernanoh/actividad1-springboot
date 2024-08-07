package com.spring_boot.Repositorio;

import com.spring_boot.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    List<Cliente> findClienteByNombre(String nombre);
}
