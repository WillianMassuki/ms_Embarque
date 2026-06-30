package br.com.ms_embarque.embarque.model;

import br.com.sistemasga.gestao.embarque.enus.StatusEmbarque;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Embarque {
    @Id
    @GeneratedValue
    private Long id;

    private UUID voo;

    @Enumerated(EnumType.STRING)
    private StatusEmbarque status;
}