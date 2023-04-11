package br.com.alura.AluraChallenge2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DespesaRequest {
    private String descricao;
    private String valor;
    private String data;
}
