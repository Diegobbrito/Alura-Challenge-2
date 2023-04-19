package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.domain.Receita;
import br.com.alura.AluraChallenge2.dto.ReceitaRequest;
import br.com.alura.AluraChallenge2.dto.ReceitaResponse;
import br.com.alura.AluraChallenge2.service.ReceitaService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping("/receitas")
    public ResponseEntity<List<Receita>> incomes(@RequestParam(required = false) String descricao){
        return ResponseEntity.ok(service.getIncomes(descricao));
    }

    @GetMapping("/receitas/{id}")
    public ResponseEntity<ReceitaResponse> income(@PathVariable Long id){
        final var response = service.getIncomes(id);
        if(response != null)
            return ResponseEntity.ok(response);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/receitas/{mes}/{ano}")
    public ResponseEntity<List<Receita>> despiseByDate(@PathVariable int mes, @PathVariable int ano) {
        final var response = service.getDespise(mes, ano);
        if (response.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/receitas")
    public ResponseEntity<Receita> create(@Valid @RequestBody ReceitaRequest request){
        final var response = service.create(request);
        URI uri = URI.create("receitas/"+ response.getId());
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/receitas/{id}")
    public ResponseEntity<Receita> update(@Valid @RequestBody ReceitaRequest request, @PathVariable Long id){
        final var response = service.update(request, id);
        if(response != null)
            return ResponseEntity.ok(response);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/receitas/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id){
        service.delete( id);
        return ResponseEntity.noContent().build();
    }
}
