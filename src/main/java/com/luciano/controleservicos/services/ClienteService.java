package com.luciano.controleservicos.services;

import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Cliente insert(Cliente obj) {
        return repository.save(obj);
    }

    public Cliente update(Cliente newObj) {
        findById(newObj.getId());
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }


}
