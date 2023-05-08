package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.Controle;
import com.stefanini.stfinancial.model.ControlePK;
import com.stefanini.stfinancial.model.Patrimonio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControleRepository extends JpaRepository<Controle,Long> {
    Page<Controle> findByContratoAtivo(boolean contratoAtivo, Pageable paginacao);
//    Page<Patrimonio> findByAll(Integer quantidadeDeVezesUtilizado);


}
