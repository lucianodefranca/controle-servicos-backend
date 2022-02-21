package com.luciano.controleservicos.services;

import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.model.repositories.ClienteRepository;
import com.luciano.controleservicos.services.exceptions.DataIntegratyViolationException;
import com.luciano.controleservicos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente insert(Cliente obj) {
        if (findByCpf(obj) != null) {
            throw  new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
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

    private Cliente findByCpf(Cliente cliente) {
        Cliente obj = repository.findByCpf(cliente.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }

}
