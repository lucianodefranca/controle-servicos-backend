package com.luciano.controleservicos.model.dtos;

import com.luciano.controleservicos.model.entities.ServicoPrestado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class ServicoPrestadoDTO {

    private String descricao;
    private String valor;
    private String data;
    private Integer idCliente;

}
