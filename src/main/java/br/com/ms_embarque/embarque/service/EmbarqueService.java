package br.com.sistemasga.gestao.embarque.service;

import br.com.sistemasga.gestao.embarque.enus.StatusEmbarque;
import br.com.sistemasga.gestao.embarque.model.CartaoEmbarque;
import br.com.sistemasga.gestao.embarque.model.Embarque;
import br.com.sistemasga.gestao.embarque.repository.CartaoEmbarqueRepository;
import br.com.sistemasga.gestao.embarque.repository.EmbarqueRepository;
import br.com.sistemasga.gestao.passageiros.model.Passageiro;
import br.com.sistemasga.gestao.passageiros.repository.PassageiroRepository;
import br.com.sistemasga.gestao.voo.model.Voo;
import br.com.sistemasga.gestao.voo.repository.VooRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmbarqueService {

    private final VooRepository vooRepo;
    private final EmbarqueRepository embarqueRepo;
    private final CartaoEmbarqueRepository cartaoRepo;
    private final PassageiroRepository passageiroRepo;

    public void iniciarEmbarque(Long vooId) {
        Voo voo = vooRepo.findById(vooId)
                .orElseThrow(() -> new RuntimeException("Voo não encontrado"));

        if (embarqueRepo.findByVoo(voo).isPresent()) {
            throw new RuntimeException("Embarque já iniciado");
        }

        Embarque embarque = new Embarque();
        embarque.setVoo(voo);
        embarque.setStatus(StatusEmbarque.EM_ANDAMENTO);

        embarqueRepo.save(embarque);
        log.info("Embarque iniciado para voo {}", voo.getCodigo());
    }

    public void embarcar(String codigoCartao) {
        CartaoEmbarque cartao = cartaoRepo.findByCodigo(codigoCartao)
                .orElseThrow(() -> new RuntimeException("Cartão inválido"));

        Embarque embarque = embarqueRepo.findByVoo(cartao.getVoo())
                .orElseThrow(() -> new RuntimeException("Embarque não iniciado"));

        if (embarque.getStatus() == StatusEmbarque.ENCERRADO) {
            throw new RuntimeException("Embarque encerrado");
        }

        Passageiro p = cartao.getPassageiro();

        if (p.getEmbarcado()) {
            throw new RuntimeException("Passageiro já embarcado");
        }

        p.setEmbarcado(true);
        passageiroRepo.save(p);

        log.info("Passageiro {} embarcado", p.getNome());
    }

    public void encerrar(Long vooId) {
        Voo voo = vooRepo.findById(vooId)
                .orElseThrow(() -> new RuntimeException("Voo não encontrado"));

        Embarque embarque = embarqueRepo.findByVoo(voo)
                .orElseThrow(() -> new RuntimeException("Embarque não iniciado"));

        embarque.setStatus(StatusEmbarque.ENCERRADO);
        embarqueRepo.save(embarque);

        log.info("Embarque encerrado voo {}", voo.getCodigo());
    }
}