package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import com.demo.formularioapi.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    private static final Long ID = 1l;
    private static final String NOME = "Walter fernando de sá";
    private static final LocalDate DTNASCIMENTO = LocalDate.of(2010, 3, 7);
    private static final List<Endereco> ENDERECO = new ArrayList<Endereco>();
    
    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private PessoaDTO pessoaDTO;

    @Captor
    private ArgumentCaptor<Pessoa> captor;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
    }

    @Test
    void saveNewEndereco() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }


    private void starterPessoa(){
        pessoaDTO = PessoaDTO.of(new Pessoa(ID ,NOME, DTNASCIMENTO, ENDERECO));
    }
}