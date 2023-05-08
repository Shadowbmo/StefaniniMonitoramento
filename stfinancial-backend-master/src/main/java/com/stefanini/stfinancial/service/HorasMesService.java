package com.stefanini.stfinancial.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.repository.HorasMesRepository;
import com.stefanini.stfinancial.request.HorasMesRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HorasMesService {

	@Autowired
	private final HorasMesRepository repo;

//	public HorasMes buscarPorId(HorasMesRequest horasMesRequest  ) {
//		return repo.findByIdHorasMes(horasMesRequest.getIdHorasMes());
//	}
	public HorasMes buscarPorMes(LocalDate mes) {
		return repo.findByMesComp(mes);
	}

	public HorasMes inserirHorasMes(HorasMes horasMes) {
		return repo.save(horasMes);
	}
	public List<HorasMes> listarHorasMes() {
		return repo.findAll();
	}
	public HorasMes alterarHorasMes(HorasMes horasMes) {
		return repo.save(horasMes);
	}
	public String deletarHorasMes(LocalDate id) {
		HorasMes mesComp = repo.findByMesComp(id);
		repo.delete(mesComp);
		return "Horas Mês deletada com sucesso!";
	}

}
