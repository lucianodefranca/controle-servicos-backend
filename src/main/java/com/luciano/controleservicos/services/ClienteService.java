package com.luciano.controleservicos.services;

import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente obj) {
        return repository.save(obj);
    }
}
