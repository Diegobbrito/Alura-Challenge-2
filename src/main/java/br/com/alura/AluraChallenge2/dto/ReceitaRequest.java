package br.com.alura.AluraChallenge2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ReceitaRequest {
    @NotBlank
    private String descricao;
    @NotBlank
    private String valor;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
}
