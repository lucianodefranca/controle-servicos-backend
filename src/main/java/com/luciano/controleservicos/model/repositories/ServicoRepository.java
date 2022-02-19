package com.luciano.controleservicos.model.repositories;

import com.luciano.controleservicos.model.entities.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servicos, Integer> {
}
