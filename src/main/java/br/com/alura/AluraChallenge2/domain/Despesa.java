package br.com.alura.AluraChallenge2.domain;

import br.com.alura.AluraChallenge2.enumarator.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(appliesTo = "despesa")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Categoria categoria;
}
