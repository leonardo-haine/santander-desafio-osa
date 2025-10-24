package br.com.santander.desafio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.desafio.app.entity.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}

