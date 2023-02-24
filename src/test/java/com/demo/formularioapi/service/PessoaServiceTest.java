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

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    private static final Long ID = 1l;
    private static final String NOME = "Walter fernando de sá";
    private static final LocalDate DTNASCIMENTO = LocalDate.of(2010, 3, 7);
    private static final Endereco ENDERECO = new Endereco();

    @NotBlank
    private Endereco endereco;

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private PessoaDTO pessoaDTO;

    @Captor
    private ArgumentCaptor<Pessoa> captor;

    @BeforeEach
    void setUp(){
        starterPessoa();
    }

    @Test
    void whenSavePessoaTest() {
        pessoaService.save(pessoaDTO);
        verify(pessoaRepository).save(captor.capture());
        Pessoa captured = captor.getValue();
        assertNotNull(captured);
    }

    @Test
    void whenFindByIdTest() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(PessoaDTO.of(pessoaDTO)));
        Optional<PessoaDTO> response = pessoaService.findById(ID);
        assertNotNull(response);
        assertEquals(Optional.class, response.getClass());
        assertEquals(ID, response.get().getId());
    }

    @Test
    void whenFindAllTest() {
        when(pessoaRepository.findAll()).thenReturn(Collections.singletonList(Pessoa.builder().build()));
        Optional<List<PessoaDTO>> response = pessoaService.findAll();
        assertNotNull(response);
        assertEquals(1,response.get().size());
        assertEquals(PessoaDTO.class, response.get().get(0).getClass());
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