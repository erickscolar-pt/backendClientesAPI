package com.clientesapi.model.repository;

import com.clientesapi.model.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    
}