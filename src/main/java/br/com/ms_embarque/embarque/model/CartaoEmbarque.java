package br.com.ms_embarque.embarque.model;


import jakarta.persistence.*;

@Entity
public class CartaoEmbarque {
    @Id
    @GeneratedValue
    private Long id;
    private String codigo;

    @ManyToOne
    private Passageiro passageiro;

    @ManyToOne
    private Voo voo;

    @OneToOne
    private CheckIn checkIn;

}