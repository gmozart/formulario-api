package com.demo.formularioapi.entity;

import com.demo.formularioapi.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_pessoa", foreignKey = @ForeignKey(name = "fk_endereco_pessoa"))
    @JsonIgnore
    private Pessoa pessoa;
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
    @NotBlank
    private String logradouro;
    @NotBlank
    private Integer cep;
    @NotBlank
    private String cidade;
}