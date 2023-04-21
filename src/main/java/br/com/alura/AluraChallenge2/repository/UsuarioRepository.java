package br.com.alura.AluraChallenge2.repository;

import br.com.alura.AluraChallenge2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByNome(String nome);
}
