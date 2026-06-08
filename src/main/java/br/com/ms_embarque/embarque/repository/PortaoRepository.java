package br.com.sistemasga.gestao.embarque.repository;

import br.com.sistemasga.gestao.embarque.model.portao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortaoRepository extends JpaRepository<portao, Long> {
    Optional<portao> findByCodigo(String codigo);
}