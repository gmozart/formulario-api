package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.EnderecoDTO;
import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.entity.Endereco;
import com.demo.formularioapi.entity.Pessoa;
import com.demo.formularioapi.enums.TipoEndereco;
import com.demo.formularioapi.exception.FmlNotFoundException;
import com.demo.formularioapi.repository.EnderecoRepository;
import com.demo.formularioapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    public void save(PessoaDTO pessoaDTO) throws Exception {
        try{
           var pessoaSalva = pessoaRepository.save(PessoaDTO.of(pessoaDTO));
            pessoaSalva.getEnderecos().forEach( endereco -> {
                endereco.setPessoa(pessoaSalva);
                enderecoRepository.save(endereco);
            });
        } catch (JpaSystemException | GenericJDBCException | DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new Exception("Dados inválidos! Verifique se os dados informados já foram cadastrados");
        }
    }

    public void saveNewEndereco(Long id, EnderecoDTO enderecoDTO){
        Pessoa pessoa = PessoaDTO.of(findById(id));
        enderecoDTO.setPessoa(pessoa);
        if(enderecoDTO.getTipoEndereco().equals(TipoEndereco.PRINCIPAL)){
            Optional<Endereco> enderecoPrincipal = pessoa.getEnderecos().stream().filter(v -> v.getTipoEndereco().equals(TipoEndereco.PRINCIPAL)).findAny();
            enderecoPrincipal.get().setTipoEndereco(TipoEndereco.SECUNDARIO);
            enderecoRepository.save(enderecoPrincipal.get());
        }
            enderecoRepository.save(EnderecoDTO.of(enderecoDTO));
    }
    public PessoaDTO findById(Long id){
        return PessoaDTO.of(pessoaRepository.findById(id)).orElseThrow(FmlNotFoundException::new);
    }
    public Optional<List<PessoaDTO>> findAll(){
        return Optional.of(PessoaDTO.of(pessoaRepository.findAll()));
    }
    public Page<PessoaDTO> findAll(Integer page, Integer size){
        return new PageImpl<>(PessoaDTO.of(pessoaRepository.findAll()), PageRequest.of(page,size),size);
    }
    public Optional<PessoaDTO> update(Long id, PessoaDTO pessoaDTO){
        pessoaDTO.setId(id);
        findById(id);
        return Optional.of(PessoaDTO.of(pessoaRepository.save(PessoaDTO.of(pessoaDTO))));
    }
    public void delete(Long id){
        findById(id);
        pessoaRepository.deleteById(id);
    }
}