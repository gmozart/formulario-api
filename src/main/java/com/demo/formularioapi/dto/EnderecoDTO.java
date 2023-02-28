package com.demo.formularioapi.dto;

import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import com.demo.formularioapi.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Long id;
    @JsonIgnore
    private Pessoa pessoa;
    private TipoEndereco tipoEndereco;
    private String logradouro;
    private Integer cep;
    private String cidade;

    public static EnderecoDTO of(Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .pessoa(endereco.getPessoa())
                .tipoEndereco(endereco.getTipoEndereco())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .build();
    }
    public static Endereco of(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .id(enderecoDTO.getId())
                .pessoa(enderecoDTO.getPessoa())
                .tipoEndereco(enderecoDTO.getTipoEndereco())
                .logradouro(enderecoDTO.getLogradouro())
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .build();
    }
    public static Optional<EnderecoDTO> of(Optional<Endereco> endereco){
        return endereco.stream().map(EnderecoDTO::of).findAny();
    }
    public static List<EnderecoDTO> of(List<Endereco> enderecoList){
        return enderecoList.stream().map(EnderecoDTO::of).collect(Collectors.toList());
    }
}
