package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Contrato;
@Repository
public interface ContratoRepository extends JpaRepository<Contrato,Long> {
}
