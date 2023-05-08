package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.Patrimonio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
    Page<Patrimonio> findByDisponivel(boolean disponivel, Pageable paginacao);
    Page<Patrimonio> findByDisponivelFalseOrOrDescartadoTrue(Pageable paginacao);
    Patrimonio findById(long id);
}
