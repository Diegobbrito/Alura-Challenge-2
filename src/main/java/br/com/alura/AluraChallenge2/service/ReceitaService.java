package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Receita;
import br.com.alura.AluraChallenge2.dto.ReceitaRequest;
import br.com.alura.AluraChallenge2.dto.ReceitaResponse;
import br.com.alura.AluraChallenge2.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;
    public List<Receita> getIncomes() {

        return repository.findAll();
    }

    public Receita create(ReceitaRequest request) {
        YearMonth yearMonth = YearMonth.of(request.getData().getYear(), request.getData().getMonth());

        final var receitas = repository.findAllByDataBetween(
                yearMonth.atDay(1),
                yearMonth.atEndOfMonth());

        final var checkElegebility = receitas
                .stream()
                .anyMatch(d -> d.getDescricao().equals(request.getDescricao()));

        if(checkElegebility){
            throw new IllegalArgumentException("Despesa já cadastrada com essa Descrição");
        }
        final var receita = Receita.builder()
        .data(request.getData())
        .valor(request.getValor())
        .descricao(request.getDescricao()).build();

        return repository.save(receita);
    }

    public ReceitaResponse getIncomes(Long id) {
        final var data = repository.findById(id);
        if(data.isEmpty())
            return null;
        final var response = data.get();
        return ReceitaResponse.builder()
                .data(response.getData())
                .valor(response.getValor())
                .descricao(response.getDescricao())
                .build();
    }

    public Receita update(ReceitaRequest request, Long id) {
        final var optionalReceita = repository.findById(id);
        if (optionalReceita.isEmpty())
            return null;
        final var receitaToUpdate = optionalReceita.get();

        final var receita = receitaToUpdate.builder()
                .id(id)
                .data(request.getData())
                .valor(request.getValor())
                .descricao(request.getDescricao())
                .build();

        return repository.save(receita);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
