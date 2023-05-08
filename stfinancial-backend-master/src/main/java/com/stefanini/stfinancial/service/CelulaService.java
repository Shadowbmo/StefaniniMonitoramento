package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.repository.CelulaRepository;
import com.stefanini.stfinancial.request.CelulaRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CelulaService {

	@Autowired
	private final CelulaRepository repo;

	public Celula buscarPorId(Long id) {
		return repo.findById(id).get();
	}

	public Celula inserirCelula(Celula celula) {
		return repo.save(celula);
	}
	public List<Celula> listarCelula() {
		return repo.findAll();
	}
	public Celula alterarCelula(Celula celula) {
		return repo.save(celula);
	}
	public String deletarCelula(Long id) {
		repo.deleteById(id);
		return "Celula deletada com sucesso!";
	}

}
