package com.demo.formularioapi.service;

import com.demo.formularioapi.dto.EnderecoDTO;
import com.demo.formularioapi.repository.EnderecoRepository;
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

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public ResponseEntity<?> save(EnderecoDTO enderecoDTO){
        try{
            return new ResponseEntity<EnderecoDTO>(EnderecoDTO.of(this.enderecoRepository.save(EnderecoDTO.of(enderecoDTO))), HttpStatus.CREATED);
        }catch (JpaSystemException | GenericJDBCException | DataIntegrityViolationException e){
            e.printStackTrace();
            return new ResponseEntity<String>(
                    "Dados inválidos! Verifique se os dados informados já foram cadastrados", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id){
        Optional<EnderecoDTO> record = EnderecoDTO.of(this.enderecoRepository.findById(id));
        if(record.orElseGet(()-> null) != null){
            return new ResponseEntity<EnderecoDTO>(record.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Endereço não localizado",  HttpStatus.BAD_REQUEST);
        }
    }

    public Optional<List<EnderecoDTO>> findAll(){
        return Optional.of(EnderecoDTO.of(enderecoRepository.findAll()));
    }
    public Page<EnderecoDTO> findAll(Integer page, Integer size){
        return new PageImpl<>(EnderecoDTO.of(enderecoRepository.findAll()), PageRequest.of(page,size),size);
    }
    public Optional<EnderecoDTO> update(Long id, EnderecoDTO enderecoDTO){
        enderecoDTO.setId(id);
        return Optional.of(EnderecoDTO.of(enderecoRepository.save(EnderecoDTO.of(enderecoDTO))));
    }
    public void delete(Long id){
        enderecoRepository.deleteById(id);
    }

}
