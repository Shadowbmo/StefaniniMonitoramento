package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Celula;
@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {

}
