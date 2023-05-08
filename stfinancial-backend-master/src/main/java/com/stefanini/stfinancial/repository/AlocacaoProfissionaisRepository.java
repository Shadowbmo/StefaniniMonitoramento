package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.AlocacaoProfissionaisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.AlocacaoProfissionais;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlocacaoProfissionaisRepository extends JpaRepository<AlocacaoProfissionais, AlocacaoProfissionaisId> {

    @Query(value = "SELECT * FROM ALOCACAO_PROFISSIONAIS WHERE MES_COMP LIKE CONCAT(?1,'%')", nativeQuery = true)
    List<AlocacaoProfissionais> findAlocacoesByMesComp(LocalDate mesComp);
}
