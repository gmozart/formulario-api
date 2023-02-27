package com.demo.formularioapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_pessoa", foreignKey = @ForeignKey(name = "fk_endereco_pessoa"))
    @JsonManagedReference
    private List<Endereco> endereco = new ArrayList<>();

}
