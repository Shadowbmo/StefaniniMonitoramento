package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.model.ClasseContrato;
import com.stefanini.stfinancial.model.Operacao;
import com.stefanini.stfinancial.repository.ClasseContratoRepository;
import com.stefanini.stfinancial.repository.OperacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.ContratoDTO;
import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.request.ContratoRequest;

@Component
public class ContratoMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OperacaoRepository operacaoRepository;

	@Autowired
	private ClasseContratoRepository classeContratoRepository;
	
	public Contrato toEntity(ContratoRequest contratoRequest) {
		Operacao operacao = operacaoRepository.findById(contratoRequest.getIdOperacao()).get();
		contratoRequest.setOperacao(operacao);
		ClasseContrato classeContrato = classeContratoRepository.findById(contratoRequest.getIdClasseContrato()).get();
		contratoRequest.setClasseContrato(classeContrato);
		return modelMapper.map(contratoRequest, Contrato.class);
	}
	
	public Contrato toDto(ContratoDTO contratoDTO) {
		return modelMapper.map(contratoDTO, Contrato.class);
	}
	
}