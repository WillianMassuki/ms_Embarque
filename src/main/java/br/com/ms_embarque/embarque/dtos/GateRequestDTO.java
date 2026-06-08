package br.com.sistemasga.gestao.embarque.dtos;

import jakarta.validation.constraints.NotBlank;

public record GateRequestDTO(
        @NotBlank String codigo
) {}