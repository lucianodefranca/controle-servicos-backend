package com.luciano.controleservicos.services;

import com.luciano.controleservicos.model.entities.Usuario;
import com.luciano.controleservicos.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario obj) {
        return repository.save(obj);
    }
}
