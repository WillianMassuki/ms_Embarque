package br.com.sistemasga.gestao.embarque.service;

import br.com.sistemasga.gestao.embarque.dtos.GateRequestDTO;
import br.com.sistemasga.gestao.embarque.dtos.GateResponseDTO;
import br.com.sistemasga.gestao.embarque.exception.BusinessException;
import br.com.sistemasga.gestao.embarque.model.portao;
import br.com.sistemasga.gestao.embarque.repository.PortaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortaoService {

    private final PortaoRepository repository;

    public GateResponseDTO create(GateRequestDTO dto) {
        log.info("Criando gate {}", dto.codigo());

        repository.findByCodigo(dto.codigo())
                .ifPresent(g -> { throw new RuntimeException("Gate já existe"); });

        portao novoPortao = portao.builder()
                .codigo(dto.codigo())
                .ativo(true)
                .build();

        repository.save(novoPortao);

        return new GateResponseDTO(novoPortao.getId(), novoPortao.getCodigo(), novoPortao.getAtivo());
    }

    public portao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gate não encontrado"));
    }
}