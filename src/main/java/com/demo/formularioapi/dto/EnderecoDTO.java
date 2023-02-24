package com.demo.formularioapi.dto;

import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.enums.TipoEndereco;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class EnderecoDTO {

    private Long id;
    @NotBlank
    private TipoEndereco tipoEndereco;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;

    public static EnderecoDTO of(Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .tipoEndereco(endereco.getTipoEndereco())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .build();
    }
    public static Endereco of(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .id(enderecoDTO.getId())
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
