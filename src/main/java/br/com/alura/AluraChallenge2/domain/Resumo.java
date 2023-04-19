package br.com.alura.AluraChallenge2.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Resumo {
    private BigDecimal totalReceita;
    private BigDecimal totalDespesa;
    private BigDecimal saldo;

    private BigDecimal alimentacao;
    private BigDecimal saude;
    private BigDecimal moradia;
    private BigDecimal transporte;
    private BigDecimal educacao;
    private BigDecimal lazer;
    private BigDecimal imprevistos;
    private BigDecimal outras;
}
