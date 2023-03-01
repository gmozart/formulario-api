package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.EnderecoDTO;
import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import com.demo.formularioapi.exception.FmlNotFoundException;
import com.demo.formularioapi.repository.EnderecoRepository;
import com.demo.formularioapi.repository.PessoaRepository;
import com.demo.formularioapi.util.PessoaResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    private static final Long ID                 = 1l;
    private static final String NOME             = "Walter fernando de sá";
    private static final LocalDate DTNASCIMENTO  = LocalDate.of(2010, 3, 7);
    private static final List<Endereco> ENDERECO = new ArrayList<Endereco>();

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    private PessoaDTO pessoaDTO;

    private Pessoa pessoa;

    private PessoaResponse pessoaResponse;

    private EnderecoDTO enderecoDTO;

    @Captor
    private ArgumentCaptor<PessoaDTO> captor;

    @BeforeEach
    void setUp() {
        starterPessoa();
    }

    @Test
    void whenSaveThenReturnPessoaResponse() throws Exception {
        when(pessoaRepository.save(any())).thenReturn(PessoaDTO.of(pessoaDTO));
        try{
           pessoaDTO.setId(1l);
           pessoaService.save(pessoaDTO);
        }catch (Exception ex){
            assertEquals(DataIntegrityViolationException.class, ex.getClass());
        }
    }

    @Test
    void saveNewEndereco() {
    }

    @Test
    void whenFindByIdThenReturnAnPessoaInstance() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(PessoaDTO.of(pessoaDTO)));
        PessoaDTO response = pessoaService.findById(ID);
        assertNotNull(response);
        assertEquals(PessoaDTO.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(DTNASCIMENTO, response.getDtNascimento());
        assertEquals(ENDERECO, response.getEnderecos());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(pessoaRepository.findById(anyLong())).thenThrow(new FmlNotFoundException("Resource not found!"));
        try{
            pessoaService.findById(ID);
        }catch (Exception ex){
            assertEquals(FmlNotFoundException.class, ex.getClass());
            assertEquals("Resource not found!", ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfPessoas() {
        when(pessoaRepository.findAll()).thenReturn(List.of(PessoaDTO.of(pessoaDTO)));
        Optional<List<PessoaDTO>> response = pessoaService.findAll();
        assertNotNull(response);
        assertEquals(1, response.get().size());
        assertEquals(PessoaDTO.class, response.get().get(0).getClass());
        assertEquals(ID, response.get().get(0).getId());
        assertEquals(NOME, response.get().get(0).getNome());
        assertEquals(DTNASCIMENTO, response.get().get(0).getDtNascimento());
        assertEquals(ENDERECO, response.get().get(0).getEnderecos());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void starterPessoa(){
        pessoaDTO = PessoaDTO.of(new Pessoa(ID ,NOME, DTNASCIMENTO, ENDERECO));
        pessoa = new Pessoa(ID ,NOME, DTNASCIMENTO, ENDERECO);
    }
}