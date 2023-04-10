package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Despesa;
import br.com.alura.AluraChallenge2.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping("/receita")
    public ResponseEntity<List<Despesa>> income(){
        return ResponseEntity.ok(service.getIncomes());
    }
}
