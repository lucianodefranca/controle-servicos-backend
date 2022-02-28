package com.luciano.controleservicos.services;

import com.luciano.controleservicos.model.dtos.ServicoPrestadoDTO;
import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.model.entities.ServicoPrestado;
import com.luciano.controleservicos.model.repositories.ClienteRepository;
import com.luciano.controleservicos.model.repositories.ServicoPrestadoRepository;
import com.luciano.controleservicos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoPrestadoService {

    @Autowired
    private ServicoPrestadoRepository repository;
    @Autowired
    private ClienteService clienteService;

    public ServicoPrestado findById(Integer id) {
        Optional<ServicoPrestado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + " ,Tipo: " + ServicoPrestado.class.getName()));
    }

    public List<ServicoPrestado> findAll() {
        return repository.findAll();
    }

    public ServicoPrestado create(ServicoPrestadoDTO obj) {
        return fromDTO(obj);
    }

    private ServicoPrestado fromDTO(ServicoPrestadoDTO obj) {

        ServicoPrestado newObj = new ServicoPrestado();
        newObj.setId(obj.getIdCliente());
        newObj.setDescricao(obj.getDescricao());
        newObj.setValor(obj.getValor());
        newObj.setData(obj.getData());

        Cliente cli = clienteService.findById(obj.getIdCliente());

        newObj.setCliente(cli);

        return repository.save(newObj);
    }


}
