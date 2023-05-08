package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Operacao;
import com.stefanini.stfinancial.repository.OperacaoRepository;
import com.stefanini.stfinancial.request.OperacaoRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperacaoService {

	@Autowired
	private final OperacaoRepository repo;

	public Operacao findByIdOperacao(Long id) {
		return repo.findById(id).get();
	}

	public Operacao inserirOperacao(Operacao operacao) {
		return repo.save(operacao);
	}
	public List<Operacao> listarOperacoes() {
		return repo.findAll();
	}
	public Operacao alterarOperacao(Operacao profissional) {
			return repo.save(profissional);
	}
	public String deletarOperacao(Long id) {
//		Operacao op = repo.findByIdOperacao(operacao.getIdOperacao());
			repo.deleteById(id);
			return "Operação deletada com sucesso";
	}

}
