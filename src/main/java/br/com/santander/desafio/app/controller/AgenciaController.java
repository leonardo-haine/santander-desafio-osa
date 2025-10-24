package br.com.santander.desafio.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.desafio.app.entity.Agencia;
import br.com.santander.desafio.app.entity.dto.AgenciaDTO;
import br.com.santander.desafio.app.entity.dto.DistanciaDTO;
import br.com.santander.desafio.app.service.AgenciaService;

@RestController
@RequestMapping("/desafio")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Agencia> cadastrar(@RequestBody AgenciaDTO dto) {
        Agencia agencia = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(agencia);
    }

    @GetMapping("/distancia")
    public ResponseEntity<List<DistanciaDTO>> consultarDistancias(
        @RequestParam double posX,
        @RequestParam double posY) {
        
        List<DistanciaDTO> distancias = service.consultarDistancias(posX, posY);
        return ResponseEntity.ok(distancias);
    }
} 	
