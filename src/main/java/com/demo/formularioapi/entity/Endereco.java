package com.demo.formularioapi.entity;

import com.demo.formularioapi.enums.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    private Long id;
    @NotBlank
    private TipoEndereco tipoEndereco;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;


}
