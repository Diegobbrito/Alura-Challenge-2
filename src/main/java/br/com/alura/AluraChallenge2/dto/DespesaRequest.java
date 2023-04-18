package br.com.alura.AluraChallenge2.dto;

import br.com.alura.AluraChallenge2.enumarator.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DespesaRequest {
    @NotBlank
    private String descricao;
    @NotBlank
    private String valor;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Categoria categoria;
}
