package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository repository;
    public List<Despesa> getDespise() {
        return repository.findAll();
    }

    public Despesa create(DespesaRequest request) {

        final var despesa = Despesa.builder()
                .data(request.getData())
                .valor(request.getValor())
                .descricao(request.getDescricao()).build();

        return repository.save(despesa);

    }
}
