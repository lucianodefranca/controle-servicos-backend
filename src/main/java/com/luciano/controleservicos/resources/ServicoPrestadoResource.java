package com.luciano.controleservicos.resources;

import com.luciano.controleservicos.model.dtos.ServicoPrestadoDTO;
import com.luciano.controleservicos.model.entities.ServicoPrestado;
import com.luciano.controleservicos.services.ServicoPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/servicos-prestados")
public class ServicoPrestadoResource {

    @Autowired
    private ServicoPrestadoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicoPrestado> findById(@PathVariable Integer id) {
        ServicoPrestado obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ServicoPrestadoDTO>> findAll() {
        List<ServicoPrestadoDTO> list =
                service.findAll().stream().map(x -> new ServicoPrestadoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ServicoPrestadoDTO> create( @RequestBody ServicoPrestadoDTO dto) {
        dto = new ServicoPrestadoDTO(service.create(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto).toUri();
        return ResponseEntity.created(uri).build();
    }

}
