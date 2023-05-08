package com.stefanini.stfinancial.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.stefanini.stfinancial.model.Controle;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatrimonioService {

    @Autowired
    private final PatrimonioRepository repo;

    public Patrimonio findByIdPatrimonio(Long id) {
        return repo.findById(id).get();
    }

    public Patrimonio inserirPatrimonio(Patrimonio patrimonio) {
        if (patrimonio.getValor() < 0) {
            throw new IllegalArgumentException("O valor não pode ser menor que zero");
        }

        if (patrimonio.getDiasUtilizado() < 0) {
            throw new IllegalArgumentException("Os dias utilizados não podem ser menores que zero");
        }

        if (patrimonio.getQuantidadeDeVezesUtilizado() < 0) {
            throw new IllegalArgumentException("A quantidade de vezes utilizado não pode ser menor que zero");
        }

        Date dataCompra = patrimonio.getDataDeCompra();
        Date dataVidaUtilEstimada = patrimonio.getVidaUtilEstimada();

        if (dataCompra.after(dataVidaUtilEstimada)) {
            throw new IllegalArgumentException("A data de compra não pode ser depois à data de vida útil estimada");
        }

        Boolean descartado = patrimonio.getDescartado();
        if (descartado) {
            throw new IllegalArgumentException("Não é possível inserir um patrimônio que esteja quebrado ou defeituoso ou vendido ou decartado  ");
        }

        return repo.save(patrimonio);
    }


    public List<Patrimonio> listarPatrimonios() {
        return repo.findAll();
    }

    public Patrimonio alterarPatrimonio(Patrimonio patrimonio) {


        return repo.save(patrimonio);
    }

    public String deletarPatrimonioDescartado(Long id) {
        Optional<Patrimonio> patrimonioOpt = repo.findById(id);
        if (patrimonioOpt.isPresent()) {
            Patrimonio patrimonio = patrimonioOpt.get();
            patrimonio.setDescartado(true);
            repo.save(patrimonio);
        } else {
            throw new RuntimeException("Patrimônio com o ID: " + id + " não foi econtrado");
        }
        return "Patrimonio deletado";

    }



    public Page<Patrimonio> findByDisponivel(boolean disponivel, PageRequest pageable) {
        return repo.findByDisponivel(disponivel, pageable);

    }
    public Page<Patrimonio> findByInativos(PageRequest pageable) {
        return repo.findByDisponivelFalseOrOrDescartadoTrue(pageable);
    }


}
