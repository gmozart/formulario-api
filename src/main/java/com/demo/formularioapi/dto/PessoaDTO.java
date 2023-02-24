package com.demo.formularioapi.dto;

import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class PessoaDTO {


    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private LocalDate dtNascimento;
    @NotBlank
    private Endereco endereco;

    public static PessoaDTO of(Pessoa pessoa){
     return PessoaDTO.builder()
             .id(pessoa.getId())
             .nome(pessoa.getNome())
             .dtNascimento(pessoa.getDtNascimento())
             .endereco(pessoa.getEndereco())
             .build();
    }
    public static Pessoa of(PessoaDTO pessoaDTO){
        return Pessoa.builder()
                .id(pessoaDTO.getId())
                .nome(pessoaDTO.getNome())
                .dtNascimento(pessoaDTO.getDtNascimento())
                .endereco(pessoaDTO.getEndereco())
                .build();
    }
    public static Optional<PessoaDTO> of(Optional<Pessoa> pessoa){
        return pessoa.stream().map(PessoaDTO::of).findAny();
    }

    public static List<PessoaDTO> of(List<Pessoa> pessoaList){
        return  pessoaList.stream().map(PessoaDTO::of).collect(Collectors.toList());
    }
}
