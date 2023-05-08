package com.stefanini.stfinancial.service;

import java.time.LocalDate;
import java.util.List;

import com.stefanini.stfinancial.model.FaturamentoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Faturamento;
import com.stefanini.stfinancial.repository.FaturamentoRepository;
import com.stefanini.stfinancial.request.FaturamentoRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FaturamentoService {

	@Autowired
	private final FaturamentoRepository repo;

	public Faturamento findByIdFaturamento(Long idContrato, String idHorasMes) {
		LocalDate mesComp = toLocalDate(idHorasMes);
		return repo.findById(new FaturamentoId(idContrato, mesComp)).get();
	}


	public Faturamento inserirFaturamento(Faturamento faturamento) {
		return repo.save(faturamento);
	}
	public List<Faturamento> listarFaturamentos() {
		return repo.findAll();
	}
	public Faturamento alterarFaturamento(Faturamento faturamento) {
			return repo.save(faturamento);
	}
	public String deletarFaturamento(Long idContrato, String idHorasMes) {
		LocalDate mesComp = toLocalDate(idHorasMes);
			repo.deleteById(new FaturamentoId(idContrato, mesComp));
			return "Faturamento deletado com sucesso";
	}
	private LocalDate toLocalDate(String idHorasMes) {
		return LocalDate.of(Integer.parseInt(idHorasMes.substring(0, 4)),
				Integer.parseInt(idHorasMes.substring(5, 7)),
				01);
	}

}
