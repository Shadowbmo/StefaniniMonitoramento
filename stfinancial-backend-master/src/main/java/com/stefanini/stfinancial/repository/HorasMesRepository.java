package com.stefanini.stfinancial.repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.HorasMes;
@Repository
public interface HorasMesRepository extends JpaRepository<HorasMes, Long> {
//	HorasMes findByIdHorasMes(Long idHorasMes);
	HorasMes findByMesComp(LocalDate mesComp);

	@Query
	void deleteByMesComp(LocalDate id);
}
