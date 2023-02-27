package com.demo.formularioapi.entity;

import com.demo.formularioapi.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_pessoa", foreignKey = @ForeignKey(name = "fk_endereco_pessoa"))
    @JsonBackReference
    private Pessoa pessoa;
    private TipoEndereco tipoEndereco;
    private String logradouro;
    private String cep;
    private String cidade;


}
