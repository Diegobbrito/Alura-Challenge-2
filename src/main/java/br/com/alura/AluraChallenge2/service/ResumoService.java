package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.domain.Resumo;
import br.com.alura.AluraChallenge2.enumarator.Categoria;
import br.com.alura.AluraChallenge2.repository.DespesaRepository;
import br.com.alura.AluraChallenge2.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

@Service
public class ResumoService {
    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    public Resumo getResume(int mes, int ano) {
        YearMonth yearMonth = YearMonth.of(ano, mes);
        final var receitas = receitaRepository.findAllByDataBetween( yearMonth.atDay(1),
                yearMonth.atEndOfMonth());
        final var despesas = despesaRepository.findAllByDataBetween( yearMonth.atDay(1),
                yearMonth.atEndOfMonth());
        final var resumo = new Resumo();

        final var receitaTotal = receitas
                .stream()
                .map(r -> r.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final var despesaTotal = despesas
                .stream()
                .map(r -> r.getValor())
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        resumo.setTotalReceita(receitaTotal);
        resumo.setTotalDespesa(despesaTotal);
        resumo.setSaldo(receitaTotal.subtract(despesaTotal));
        resumo.setAlimentacao(getDespesas(despesas, Categoria.ALIMENTACAO));
        resumo.setSaude(getDespesas(despesas, Categoria.SAUDE));
        resumo.setMoradia(getDespesas(despesas, Categoria.MORADIA));
        resumo.setTransporte(getDespesas(despesas, Categoria.TRANSPORTE));
        resumo.setEducacao(getDespesas(despesas, Categoria.EDUCACAO));
        resumo.setLazer(getDespesas(despesas, Categoria.LAZER));
        resumo.setImprevistos(getDespesas(despesas, Categoria.IMPREVISTOS));
        resumo.setOutras(getDespesas(despesas, Categoria.OUTRAS));

        return resumo;
    }

    private static BigDecimal getDespesas(List<Despesa> despesas, Categoria categoria) {
        return despesas
                .stream()
                .filter(r -> r.getCategoria().equals(categoria))
                .map(r -> r.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
