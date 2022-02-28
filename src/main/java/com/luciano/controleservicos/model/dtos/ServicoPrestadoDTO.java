package com.luciano.controleservicos.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luciano.controleservicos.model.entities.ServicoPrestado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor
public class ServicoPrestadoDTO {

    private String descricao;
    private Double valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    private Integer idCliente;

    public ServicoPrestadoDTO(ServicoPrestado dto) {
        descricao = dto.getDescricao();
        valor = dto.getValor();
        data = dto.getData();
        idCliente = dto.getCliente().getId();
    }

}
