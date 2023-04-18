package br.com.alura.AluraChallenge2.repository;

import br.com.alura.AluraChallenge2.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findAllByDataBetween(
            LocalDate start,
            LocalDate end);

    List<Despesa> findByDescricaoContains(String descricao);
}
