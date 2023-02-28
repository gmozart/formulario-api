package com.demo.formularioapi.dto;

import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class PessoaDTO {

    @JsonIgnore
    private Long id;
    private String nome;
    private LocalDate dtNascimento;
    private List<Endereco> enderecos;

    public static PessoaDTO of(Pessoa pessoa){
     return PessoaDTO.builder()
             .id(pessoa.getId())
             .nome(pessoa.getNome())
             .dtNascimento(pessoa.getDtNascimento())
             .enderecos(pessoa.getEnderecos())
             .build();
    }
    public static Pessoa of(PessoaDTO pessoaDTO){
        return Pessoa.builder()
                .id(pessoaDTO.getId())
                .nome(pessoaDTO.getNome())
                .dtNascimento(pessoaDTO.getDtNascimento())
                .enderecos(pessoaDTO.getEnderecos())
                .build();
    }
    public static Optional<PessoaDTO> of(Optional<Pessoa> pessoa){
        return pessoa.stream().map(PessoaDTO::of).findAny();
    }

    public static List<PessoaDTO> of(List<Pessoa> pessoaList){
        return  pessoaList.stream().map(PessoaDTO::of).collect(Collectors.toList());
    }
}