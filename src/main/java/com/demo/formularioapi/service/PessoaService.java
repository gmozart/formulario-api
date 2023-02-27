package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public ResponseEntity<?> save(PessoaDTO pessoaDTO){
        try{
            return new ResponseEntity<PessoaDTO>(PessoaDTO.of(this.pessoaRepository.save(PessoaDTO.of(pessoaDTO))), HttpStatus.CREATED);
        } catch (JpaSystemException | GenericJDBCException | DataIntegrityViolationException e){
            e.printStackTrace();
            return new ResponseEntity<String>(
                "Dados inválidos! Verifique se os dados informados já foram cadastrados", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id){
            Optional<PessoaDTO> record = PessoaDTO.of(this.pessoaRepository.findById(id));
            if (record.orElseGet(()-> null) != null){
                return new ResponseEntity<PessoaDTO>(record.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<String>("Pessoa não localziada!", HttpStatus.BAD_REQUEST);
            }
    }

    public Optional<List<PessoaDTO>> findAll(){
        return Optional.of(PessoaDTO.of(pessoaRepository.findAll()));
    }
    public Page<PessoaDTO> findAll(Integer page, Integer size){
        return new PageImpl<>(PessoaDTO.of(pessoaRepository.findAll()), PageRequest.of(page,size),size);
    }
    public Optional<PessoaDTO> update(Long id, PessoaDTO pessoaDTO){
        pessoaDTO.setId(id);
        return Optional.of(PessoaDTO.of(pessoaRepository.save(PessoaDTO.of(pessoaDTO))));
    }
    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }
}