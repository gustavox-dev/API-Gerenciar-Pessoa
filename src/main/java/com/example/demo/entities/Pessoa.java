package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name = "pessoa")
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Date dataNascimento;

    @OneToMany
    private List<Endereco> endereco;
}
