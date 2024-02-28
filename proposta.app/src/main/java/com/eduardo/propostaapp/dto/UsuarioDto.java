package com.eduardo.propostaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    private String name;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private Double renda;
}