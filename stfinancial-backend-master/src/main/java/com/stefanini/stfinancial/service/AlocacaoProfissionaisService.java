package com.stefanini.stfinancial.service;

import java.time.LocalDate;
import java.util.List;

import com.stefanini.stfinancial.model.AlocacaoProfissionaisId;
import com.stefanini.stfinancial.model.ProfissionalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.repository.AlocacaoProfissionaisRepository;
import com.stefanini.stfinancial.request.AlocacaoProfissionaisRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlocacaoProfissionaisService {

	@Autowired
	private final AlocacaoProfissionaisRepository repo;

	public AlocacaoProfissionais findByIdAlocacaoProfissionais(String idHorasMes, Long idContrato, Long matricula) {
		LocalDate mesComp = toLocalDate(idHorasMes);
		return repo.findById(new AlocacaoProfissionaisId(idContrato, new ProfissionalId(matricula, mesComp))).get();
	}

	public AlocacaoProfissionais inserirAlocacaoProfissionais(AlocacaoProfissionais alocacaoProfissionais) {
		return repo.save(alocacaoProfissionais);
	}
	public List<AlocacaoProfissionais> listarAlocacaoProfissionais() {
		return repo.findAll();
	}
	public AlocacaoProfissionais alterarAlocacaoProfissionais(AlocacaoProfissionais alocacaoProfissionais) {
			return repo.save(alocacaoProfissionais);
	}
	public String deletarAlocacaoProfissionais(String idHorasMes, Long idContrato, Long matricula) {
		LocalDate mesComp = toLocalDate(idHorasMes);
		repo.deleteById(new AlocacaoProfissionaisId(idContrato, new ProfissionalId(matricula, mesComp)));
		return "Alocação Profissional deletada com sucesso";
	}

	public LocalDate toLocalDate(String idHorasMes){
		return 	LocalDate.of(
				Integer.parseInt(idHorasMes.substring(0, 4)),
				Integer.parseInt(idHorasMes.substring(5, 7)),
				01
		);
	}

	public List<AlocacaoProfissionais> listarAlocacaoProfissionaisByMes(LocalDate mes) {
		return repo.findAlocacoesByMesComp(mes);
	}
}
