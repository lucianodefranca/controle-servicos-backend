package com.luciano.controleservicos.model.repositories;

import com.luciano.controleservicos.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT obj FROM Cliente obj WHERE obj.cpf =:cpf")
    Cliente findByCpf(@Param(value = "cpf") String cpf);
}
