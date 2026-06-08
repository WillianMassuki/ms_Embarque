package br.com.sistemasga.gestao.embarque.repository;

import br.com.sistemasga.gestao.embarque.model.Embarque;
import br.com.sistemasga.gestao.voo.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmbarqueRepository extends JpaRepository<Embarque, Long> {
    Optional<Embarque> findByVoo(Voo voo);
}