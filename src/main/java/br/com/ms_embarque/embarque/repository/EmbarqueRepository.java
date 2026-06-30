package br.com.ms_embarque.embarque.repository;

import br.com.ms_embarque.embarque.model.Embarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmbarqueRepository extends JpaRepository<Embarque, Long> {
    Optional<Embarque> findByVoo(UUID voo);
}