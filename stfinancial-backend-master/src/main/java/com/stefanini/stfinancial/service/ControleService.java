package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.Controle;
import com.stefanini.stfinancial.model.ControlePK;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.repository.ControleRepository;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import com.stefanini.stfinancial.repository.ProfissionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ControleService {
    @Autowired
    private final ControleRepository repo;
    @Autowired
    private PatrimonioRepository repoPatri;
    @Autowired
    private final ProfissionalRepository repoProfi;


    public Controle inserirControle(Controle controle) {
//       ---- ---- ---- ---- ---- Data De Entrega ---- ---- ---- ---- ----
        Date dataDeEntrega = controle.getDataDeEntregaDoPatrimonio();
        Date dataDeDevolucao = controle.getDataDeDevolucaoDoPatrimonio();

        if (dataDeDevolucao != null && dataDeEntrega.after(dataDeDevolucao)) {
            throw new RuntimeException("Não é possível devolver um patrimônio antes de tê-lo entregue");
        }
//       ---- ---- ---- ---- ---- Patrimonio ---- ---- ---- ---- ----
        Long patrimonioId = controle.getPatrimonio().getIdPatrimonio();
        Patrimonio patrimonio = repoPatri.findById(patrimonioId).orElse(null);
        if (patrimonio == null) {
            throw new EntityNotFoundException("Patrimônio não encontrado com o ID: " + patrimonioId);
        }
        if(patrimonio.getDisponivel() == false){
            throw new RuntimeException("O patriomonio informado já está sendo ultilizado e por isso não foi possivel cadastrar");
        }
        if(patrimonio.getDescartado() == true){
            throw new RuntimeException("O patriomonio informado está descartado e por isso não foi possivel cadastrar");
        }
        patrimonio.setDisponivel(false);
        patrimonio.setQuantidadeDeVezesUtilizado(patrimonio.getQuantidadeDeVezesUtilizado() + 1);
        repoPatri.save(patrimonio);

        return repo.save(controle);
    }

    public void atualizarContratoAtivo(String mesComp, Long id, Long matricula) {
//        ControlePK controleId = new ControlePK();
//        controleId.se;
//        controleId.setIdControle(idControle);
//        controleId.setMatricula(matricula);
//
//        Optional<Controle> controleOpt = repo.findById(controleId);
//        if (controleOpt.isPresent()) {
//            Controle controle = controleOpt.get();
//            controle.setContratoAtivo(false);
//            repo.save(controle);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    public Page<Controle> findByContratoInativo(boolean contratoAtivo, Pageable pageable) {

        return repo.findByContratoAtivo(contratoAtivo, pageable);
    }

    public Page<Controle> findByContratoAtivo(boolean contratoAtivo, Pageable pageable) {
        return repo.findByContratoAtivo(contratoAtivo, pageable);
    }

    public Object alterarControle(Controle controle) {
        return repo.save(controle);
    }
}


