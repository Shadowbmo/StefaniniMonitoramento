package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.model.Cliente;
import com.stefanini.stfinancial.repository.CelulaRepository;
import com.stefanini.stfinancial.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.OperacaoDTO;
import com.stefanini.stfinancial.model.Operacao;
import com.stefanini.stfinancial.request.OperacaoRequest;

@Component
public class OperacaoMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CelulaRepository celulaRepository;
	
	public Operacao toEntity(OperacaoRequest operacaoRequest) {
		Cliente cliente = clienteRepository.findById(operacaoRequest.getClienteId()).get();
		operacaoRequest.setCliente(cliente);
		Celula celula = celulaRepository.findById(operacaoRequest.getCelulaId()).get();
		operacaoRequest.setCelula(celula);
		return modelMapper.map(operacaoRequest, Operacao.class);
	}
	
	public Operacao toDto(OperacaoDTO operacaoDTO) {
		return modelMapper.map(operacaoDTO, Operacao.class);
	}
	
}