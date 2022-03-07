package com.luciano.controleservicos.resources;

import com.luciano.controleservicos.model.entities.Usuario;
import com.luciano.controleservicos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:4200")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid Usuario obj) {
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
