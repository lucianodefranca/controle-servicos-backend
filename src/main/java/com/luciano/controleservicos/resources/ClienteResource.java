package com.luciano.controleservicos.resources;

import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
        Cliente newObj = service.insert(obj);
        return ResponseEntity.ok().build();
    }
}
