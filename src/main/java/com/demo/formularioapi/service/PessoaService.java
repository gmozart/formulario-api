package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.entity.Pessoa;
import com.demo.formularioapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public void save(PessoaDTO pessoaDTO){
        pessoaRepository.save(PessoaDTO.of(pessoaDTO));
    }
    public Optional<PessoaDTO> findById(Long id){
        return PessoaDTO.of(pessoaRepository.findById(id));
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