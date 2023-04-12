package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.domain.Receita;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.dto.DespesaResponse;
import br.com.alura.AluraChallenge2.service.DespesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping("/despesas")
    public ResponseEntity<List<Despesa>> despises() {
        return ResponseEntity.ok(service.getDespise());
    }

    @GetMapping("/despesas/{id}")
    public ResponseEntity<DespesaResponse> despise(@PathVariable Long id) {
        final var response = service.getDespise(id);
        if (response != null)
            return ResponseEntity.ok(service.getDespise(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/despesas")
    public ResponseEntity<Despesa> create(@Valid @RequestBody DespesaRequest request){
        final var response = service.create(request);
        URI uri = URI.create("despesa/"+ response.getId());
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/despesas/{id}")
    public ResponseEntity<Despesa> update(@Valid @RequestBody DespesaRequest request, @PathVariable Long id){
        final var response = service.update(request, id);
        if (response != null)
            return ResponseEntity.ok(response);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/despesas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete( id);
        return ResponseEntity.noContent().build();
    }
}
