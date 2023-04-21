package br.com.alura.AluraChallenge2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotNull
    private String nome;

    @NotNull
    private String senha;

    private Boolean autoridades;
}
