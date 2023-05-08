package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.FaturamentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Faturamento;
@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, FaturamentoId> {
}
