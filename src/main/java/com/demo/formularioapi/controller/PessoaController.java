package com.demo.formularioapi.controller;

import com.demo.formularioapi.dto.EnderecoDTO;
import com.demo.formularioapi.dto.PessoaDTO;
import com.demo.formularioapi.exception.FmlNotFoundException;
import com.demo.formularioapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PessoaDTO pessoaDTO){
        return pessoaService.save(pessoaDTO);
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<?> saveNewEndereco (@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        return pessoaService.saveNewEndereco(id, enderecoDTO);
    }

    @GetMapping("/{id}")
    public PessoaDTO findByid(@PathVariable  Long id){
        return pessoaService.findById(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll().orElseThrow(FmlNotFoundException::new));
    }
    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> pageAll(@RequestParam Integer page, @RequestParam Integer size){
        return  ResponseEntity.ok(pessoaService.findAll(page,size));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok(pessoaService.update(id, pessoaDTO).orElseThrow(FmlNotFoundException::new));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
