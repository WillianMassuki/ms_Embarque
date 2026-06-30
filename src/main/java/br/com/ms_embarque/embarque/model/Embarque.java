package br.com.ms_embarque.embarque.model;

import br.com.ms_embarque.embarque.enus.StatusEmbarque;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Embarque {
    @Id
    @GeneratedValue
    private Long id;

    private UUID voo;

    @Enumerated(EnumType.STRING)
    private StatusEmbarque status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getVoo() {
        return voo;
    }

    public void setVoo(UUID voo) {
        this.voo = voo;
    }

    public StatusEmbarque getStatus() {
        return status;
    }

    public void setStatus(StatusEmbarque status) {
        this.status = status;
    }
}