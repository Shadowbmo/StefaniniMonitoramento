package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.SituacaoParcela;
@Repository
public interface SituacaoParcelaRepository extends JpaRepository<SituacaoParcela, Long> {

}
