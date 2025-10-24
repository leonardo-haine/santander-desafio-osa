package br.com.santander.desafio.app.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import br.com.santander.desafio.app.entity.Agencia;
import br.com.santander.desafio.app.entity.dto.AgenciaDTO;
import br.com.santander.desafio.app.entity.dto.DistanciaDTO;
import br.com.santander.desafio.app.repository.AgenciaRepository;

@Service
@EnableCaching
public class AgenciaService {

    @Autowired
    private AgenciaRepository repository;

    @Cacheable(value = "distancias", key = "#x + '-' + #y")
    public List<DistanciaDTO> consultarDistancias(double x, double y) {
        List<Agencia> agencias = repository.findAll();
        return agencias.stream()
            .map(agencia -> new DistanciaDTO(
                agencia.getNome(),
                calcularDistancia(agencia.getCoordenadaX(), agencia.getCoordenadaY(), x, y)))
            .sorted(Comparator.comparingDouble(DistanciaDTO::distancia))
            .collect(Collectors.toList());
    }

    public Agencia salvar(AgenciaDTO dto) {
        Agencia agencia = new Agencia();
        agencia.setNome(dto.nome());
        agencia.setCoordenadaX(dto.posX());
        agencia.setCoordenadaY(dto.posY());
        return repository.save(agencia);
    }

    private double calcularDistancia(double x, double y, double usuarioX, double usuarioY) {


            double distancia = Math.sqrt(Math.pow(x - usuarioX, 2) + Math.pow(y - usuarioY, 2));

        return distancia;
    }
}
