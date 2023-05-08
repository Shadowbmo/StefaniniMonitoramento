package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.ClasseContrato;
import com.stefanini.stfinancial.repository.ClasseContratoRepository;
import com.stefanini.stfinancial.request.ClasseContratoRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasseContratoService {

	@Autowired
	private final ClasseContratoRepository repo;

	public ClasseContrato findByIdClasseContrato(Long id) {
		return repo.findById(id).get();
	}

	public ClasseContrato inserirClasseContrato(ClasseContrato classeContrato) {
		return repo.save(classeContrato);
	}
	public List<ClasseContrato> listarClasseContratos() {
		return repo.findAll();
	}
	public ClasseContrato alterarClasseContrato(ClasseContrato classeContrato) {
			return repo.save(classeContrato);
	}
	public String deletarClasseContrato(Long id) {
//		ClasseContrato classe = repo.findByIdClasseContrato(situacaoParcela.getIdClasseContrato());
			repo.deleteById(id);
			return "Classe Contrato deletada com sucesso";
	}

}
