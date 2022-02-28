package com.luciano.controleservicos.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private Double valor;

    @Column
    private LocalDate data;
}
