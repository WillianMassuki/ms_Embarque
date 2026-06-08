package br.com.sistemasga.gestao.embarque.controller;

import br.com.sistemasga.gestao.embarque.dtos.GateRequestDTO;
import br.com.sistemasga.gestao.embarque.dtos.GateResponseDTO;
import br.com.sistemasga.gestao.embarque.service.PortaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gates")
@RequiredArgsConstructor
public class PortaoController {

    private final PortaoService service;

    @PostMapping
    public GateResponseDTO create(@RequestBody @Valid GateRequestDTO dto) {
        return service.create(dto);
    }
}