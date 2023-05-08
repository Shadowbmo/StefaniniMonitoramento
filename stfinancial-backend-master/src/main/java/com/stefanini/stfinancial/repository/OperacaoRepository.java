package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Operacao;
@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
