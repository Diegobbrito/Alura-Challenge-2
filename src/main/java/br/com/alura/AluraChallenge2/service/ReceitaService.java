package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.domain.Receita;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.dto.ReceitaRequest;
import br.com.alura.AluraChallenge2.repository.DespesaRepository;
import br.com.alura.AluraChallenge2.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;
    public List<Receita> getIncomes() {

        return repository.findAll();
    }

    public Receita create(ReceitaRequest request) {
        final var receita = Receita.builder()
                .data(request.getData())
                .valor(request.getValor())
                .descricao(request.getDescricao()).build();

        return repository.save(receita);
    }
}
