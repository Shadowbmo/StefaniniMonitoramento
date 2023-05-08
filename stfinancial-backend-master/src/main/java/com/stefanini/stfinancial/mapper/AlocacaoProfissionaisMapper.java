package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.model.ProfissionalId;
import com.stefanini.stfinancial.repository.ContratoRepository;
import com.stefanini.stfinancial.repository.ProfissionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.AlocacaoProfissionaisDTO;
import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.request.AlocacaoProfissionaisRequest;

@Component
public class AlocacaoProfissionaisMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public AlocacaoProfissionais toEntity(AlocacaoProfissionaisRequest alocacaoProfissionaisRequest) {
		System.out.println(alocacaoProfissionaisRequest);
		Contrato contrato = contratoRepository.findById(alocacaoProfissionaisRequest.getIdContrato()).get();
		alocacaoProfissionaisRequest.setContrato(contrato);
		Profissional profissional = profissionalRepository.findById(new ProfissionalId(alocacaoProfissionaisRequest.getIdProfissional().getMatricula(), alocacaoProfissionaisRequest.getIdProfissional().getHorasMes())).get();
		alocacaoProfissionaisRequest.setProfissional(profissional);
		return modelMapper.map(alocacaoProfissionaisRequest, AlocacaoProfissionais.class);
	}
	
	public AlocacaoProfissionais toDto(AlocacaoProfissionaisDTO alocacaoProfissionaisDTO) {
		return modelMapper.map(alocacaoProfissionaisDTO, AlocacaoProfissionais.class);
	}
	
}