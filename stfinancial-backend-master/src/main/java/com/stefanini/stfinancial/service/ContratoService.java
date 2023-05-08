package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.repository.ContratoRepository;
import com.stefanini.stfinancial.request.ContratoRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContratoService {

	@Autowired
	private final ContratoRepository repo;

	public Contrato findByIdContrato(Long id) {
		return repo.findById(id).get();
	}

	public Contrato inserirContrato(Contrato operacao) {
		return repo.save(operacao);
	}
	public List<Contrato> listarContratos() {
		return repo.findAll();
	}
	public Contrato alterarContrato(Contrato contrato) {
			return repo.save(contrato);
	}
	public String deletarContrato(Long id) {
//		Contrato con = repo.findByIdContrato(contrato.getIdContrato());
			repo.deleteById(id);
			return "Contrato deletado com sucesso";
	}

}
