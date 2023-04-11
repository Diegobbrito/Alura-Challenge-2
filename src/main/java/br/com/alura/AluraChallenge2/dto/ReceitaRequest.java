package br.com.alura.AluraChallenge2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceitaRequest {
    private String descricao;
    private String valor;
    private String data;
}
