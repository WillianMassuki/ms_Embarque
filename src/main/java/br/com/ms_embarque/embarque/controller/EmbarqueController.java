package br.com.ms_embarque.embarque.controller;

import br.com.ms_embarque.embarque.dtos.EmbarqueRequestDTO;
import br.com.ms_embarque.embarque.service.EmbarqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/embarque")
public class EmbarqueController {

    private final EmbarqueService service;

    public EmbarqueController(EmbarqueService service) {
        this.service = service;
    }

    /*
    @PostMapping("/iniciar")
    public ResponseEntity<Void> iniciar(@RequestBody EmbarqueRequestDTO dto) {
        service.iniciarEmbarque(dto.vooId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validar")
    public ResponseEntity<Void> validar(@RequestBody CartaoDTO dto) {
        service.embarcar(dto.codigoCartao());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/encerrar/{vooId}")
    public ResponseEntity<Void> encerrar(@PathVariable Long vooId) {
        service.encerrar(vooId);
        return ResponseEntity.ok().build();
    }
    
     */
}