package br.com.alura.AluraChallenge2.service;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.dto.DespesaResponse;
import br.com.alura.AluraChallenge2.enumarator.Categoria;
import br.com.alura.AluraChallenge2.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository repository;

    public Despesa create(DespesaRequest request) {
        checkDataElegebility(request);
        checkCategory(request);
        final var despesa = Despesa.builder()
                .data(request.getData())
                .valor(request.getValor())
                .descricao(request.getDescricao())
                .categoria(request.getCategoria())
                .build();

        return repository.save(despesa);

    }

    private void checkCategory(DespesaRequest request) {
        if(request.getCategoria() == null){
            request.setCategoria(Categoria.OUTRAS);
        }
    }

    private void checkDataElegebility(DespesaRequest request) {
        final var yearMonth = YearMonth.of(request.getData().getYear(), request.getData().getMonth());
        final var checkElegebility = repository.findAllByDataBetween(
                yearMonth.atDay(1),
                yearMonth.atEndOfMonth())
                .stream()
                .anyMatch(d -> d.getDescricao().equals(request.getDescricao()));
        if(checkElegebility){
            throw new IllegalArgumentException("Despesa já cadastrada com essa Descrição");
        }
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

        final var optionalDespesa = repository.findById(id);
        if (optionalDespesa.isEmpty())
            return null;
        final var despesaToUpdate = optionalDespesa.get();

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



    public List<Despesa> getDespise(String descricao) {
        if (descricao == null)
            return repository.findAll();
        return repository.findByDescricaoContains(descricao);
    }

    public List<Despesa> getDespise(int mes, int ano) {

        final var yearMonth = YearMonth.of(ano, mes);
        return repository.findAllByDataBetween(
                        yearMonth.atDay(1),
                        yearMonth.atEndOfMonth());
    }
}
