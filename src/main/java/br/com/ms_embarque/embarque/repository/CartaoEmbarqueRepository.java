package br.com.sistemasga.gestao.embarque.repository;

import br.com.sistemasga.gestao.embarque.model.CartaoEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoEmbarqueRepository extends JpaRepository<CartaoEmbarque, Long> {
    Optional<CartaoEmbarque> findByCodigo(String codigo);
}