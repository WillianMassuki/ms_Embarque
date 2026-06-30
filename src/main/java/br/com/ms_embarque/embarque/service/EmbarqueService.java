package br.com.ms_embarque.embarque.service;

import br.com.ms_embarque.embarque.repository.EmbarqueRepository;
import org.springframework.stereotype.Service;

@Service
public class EmbarqueService {

    private final EmbarqueRepository embarqueRepo;

    public EmbarqueService(EmbarqueRepository embarqueRepo) {
        this.embarqueRepo = embarqueRepo;
    }

    /*
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

     */
}