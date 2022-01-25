package com.clientesapi.model.repository;

import com.clientesapi.model.entity.Servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    
}
