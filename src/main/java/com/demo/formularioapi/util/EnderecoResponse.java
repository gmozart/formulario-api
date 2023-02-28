package com.demo.formularioapi.util;

import com.demo.formularioapi.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {

    private Endereco endereco;

    public static EnderecoResponse of(Endereco endereco){
        return EnderecoResponse.builder().build();
    }
}
