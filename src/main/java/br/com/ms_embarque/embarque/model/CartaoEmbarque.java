package br.com.ms_embarque.embarque.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CartaoEmbarque {
    @Id
    @GeneratedValue
    private Long id;

    private String codigo;

    private UUID passageiro;

    private UUID voo;

    private UUID checkIn;

}