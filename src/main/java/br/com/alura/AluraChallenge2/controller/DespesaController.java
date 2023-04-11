package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.dto.DespesaRequest;
import br.com.alura.AluraChallenge2.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping("/despesa")
    public ResponseEntity<List<Despesa>> despise() {
        return ResponseEntity.ok(service.getDespise());
    }

    @PostMapping("despesa")
    public ResponseEntity<Despesa> create(@RequestBody DespesaRequest request){
        final var response = service.create(request);
        URI uri = URI.create("despesa/"+ response.getId());
        return ResponseEntity.created(uri).body(response);
    }
}
