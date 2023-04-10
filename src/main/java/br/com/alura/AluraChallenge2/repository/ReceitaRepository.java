package br.com.alura.AluraChallenge2.repository;

import br.com.alura.AluraChallenge2.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long> {
}
