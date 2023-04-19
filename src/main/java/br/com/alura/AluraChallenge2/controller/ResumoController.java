package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Resumo;
import br.com.alura.AluraChallenge2.service.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumoController {

    @Autowired
    private ResumoService service;

    @GetMapping("/resumo/{mes}/{ano}")
    public ResponseEntity<Resumo> allByDate(@PathVariable int mes, @PathVariable int ano) {
        final var response = service.getResume(mes, ano);
        return ResponseEntity.ok(response);
    }

}
