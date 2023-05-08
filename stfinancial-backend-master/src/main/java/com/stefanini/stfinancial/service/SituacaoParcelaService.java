package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.SituacaoParcela;
import com.stefanini.stfinancial.repository.SituacaoParcelaRepository;
import com.stefanini.stfinancial.request.SituacaoParcelaRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SituacaoParcelaService {

	@Autowired
	private final SituacaoParcelaRepository repo;

	public SituacaoParcela findByIdSituacaoParcela(Long id ) {
		return repo.findById(id).get();
	}

	public SituacaoParcela inserirSituacaoParcela(SituacaoParcela situacaoParcela) {
		return repo.save(situacaoParcela);
	}
	public List<SituacaoParcela> listarSituacaoParcelas() {
		return repo.findAll();
	}
	public SituacaoParcela alterarSituacaoParcela(SituacaoParcela situacaoParcela) {
			return repo.save(situacaoParcela);
	}
	public String deletarSituacaoParcela(Long codigoSituacaoParcela) {
			repo.deleteById(codigoSituacaoParcela);
			return "Situação Parcela deletada com sucesso";
	}

}
