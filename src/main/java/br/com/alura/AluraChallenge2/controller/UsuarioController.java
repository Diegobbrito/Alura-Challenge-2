package br.com.alura.AluraChallenge2.controller;

import br.com.alura.AluraChallenge2.domain.Usuario;
import br.com.alura.AluraChallenge2.dto.UsuarioRequest;
import br.com.alura.AluraChallenge2.dto.UsuarioResponse;
import br.com.alura.AluraChallenge2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "login", produces = "application/json")
    public UsuarioResponse validateLogin(@RequestBody String username) {
        return usuarioService.findUser(username);
    }

    @PostMapping("/new")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioRequest user){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(user));
    }

    @PutMapping("edit")
    public ResponseEntity<UsuarioResponse> update(@RequestBody UsuarioRequest user){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.update(user));
    }

}
