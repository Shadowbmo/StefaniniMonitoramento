package com.stefanini.stfinancial.repository;

//import com.stefanini.stfinancial.model.ProfissionalId;
import com.stefanini.stfinancial.model.ProfissionalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Profissional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, ProfissionalId> {

    List<Profissional> findByHorasMesMesComp(LocalDate mesComp);

    List<Profissional> findByIdProfissionalMatricula(Long matricula);
}
