package br.com.alura.AluraChallenge2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ReceitaResponse {
    private String descricao;
    private String valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
}
