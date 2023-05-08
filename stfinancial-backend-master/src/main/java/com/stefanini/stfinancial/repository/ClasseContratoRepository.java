package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.ClasseContrato;
@Repository
public interface ClasseContratoRepository extends JpaRepository<ClasseContrato, Long> {
}
