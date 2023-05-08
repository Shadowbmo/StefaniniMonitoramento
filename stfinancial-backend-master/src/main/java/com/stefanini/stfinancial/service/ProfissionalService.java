package com.stefanini.stfinancial.service;

import java.time.LocalDate;
import java.util.List;

import com.stefanini.stfinancial.model.ProfissionalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.repository.ProfissionalRepository;
import com.stefanini.stfinancial.request.ProfissionalRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfissionalService {

	@Autowired
	private final ProfissionalRepository repo;

	public Profissional findByIdProfissional(Long matricula, String idHorasMes) {
		LocalDate mesComp = toLocalDate(idHorasMes);
		return repo.findById(new ProfissionalId(matricula, mesComp)).get();
	}

	public Profissional inserirProfissional(Profissional profissional) {
		return repo.save(profissional);
	}
	public List<Profissional> listarProfissionais() {
		return repo.findAll();
	}
	public List<Profissional> listarProfissionaisByMes(LocalDate mesComp) {
		return repo.findByHorasMesMesComp(mesComp);
	}
	public Profissional alterarProfissional(Profissional profissional) {
			return repo.save(profissional);
	}

	public String deletarProfissional(Long matricula, String idHorasMes) {
		LocalDate mesComp = toLocalDate(idHorasMes);
		repo.deleteById(new ProfissionalId(matricula, mesComp));
		return "Profissional deletado com sucesso";
	}

	public LocalDate toLocalDate(String idHorasMes){
		return 	LocalDate.of(
				Integer.parseInt(idHorasMes.substring(0, 4)),
				Integer.parseInt(idHorasMes.substring(5, 7)),
				01
		);
	}
}
