package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Receita;
import br.com.alura.AluraChallenge2.dto.ReceitaRequest;
import br.com.alura.AluraChallenge2.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping("/receita")
    public ResponseEntity<List<Receita>> income(){
        return ResponseEntity.ok(service.getIncomes());
    }

    @PostMapping("/receita")
    public ResponseEntity<Receita> create(@RequestBody ReceitaRequest request){
        final var response = service.create(request);
        URI uri = URI.create("receita/"+ response.getId());
        return ResponseEntity.created(uri).body(response);
    }
}
