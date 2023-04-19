package br.com.alura.AluraChallenge2.repository;

import br.com.alura.AluraChallenge2.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long> {

    List<Receita> findAllByDataBetween(
            LocalDate start,
            LocalDate end);

    List<Receita> findAllByDescricaoContaining(String descricao);
}
