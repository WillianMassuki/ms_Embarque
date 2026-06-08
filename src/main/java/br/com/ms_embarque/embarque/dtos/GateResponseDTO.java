package br.com.sistemasga.gestao.embarque.dtos;

public record GateResponseDTO(
        Long id,
        String codigo,
        Boolean ativo
) {}