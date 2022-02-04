package com.clientesapi.model.repository;

import com.clientesapi.model.entity.ServicoPrestado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
    
}
