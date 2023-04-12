package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.dto.DespesaResponse;
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

    public DespesaResponse getDespise(Long id) {
        final var optionalDespesa = repository.findById(id);
        if(optionalDespesa.isEmpty())
            return null;
        final var response = optionalDespesa.get();
        return DespesaResponse.builder()
                .data(response.getData())
                .valor(response.getValor())
                .descricao(response.getDescricao())
                .build();
    }

    public Despesa update(DespesaRequest request, Long id) {

        final var despesaToUpdate = repository.findById(id).get();

        final var despesa = despesaToUpdate.builder()
                .id(id)
                .data(request.getData())
                .valor(request.getValor())
                .descricao(request.getDescricao()).build();

        return repository.save(despesa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
