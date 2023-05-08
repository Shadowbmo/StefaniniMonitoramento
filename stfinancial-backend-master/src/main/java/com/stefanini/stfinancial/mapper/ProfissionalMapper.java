package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.Operacao;
import com.stefanini.stfinancial.model.ProfissionalId;
import com.stefanini.stfinancial.repository.HorasMesRepository;
import com.stefanini.stfinancial.repository.OperacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.ProfissionalDTO;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.request.ProfissionalRequest;

import java.util.Optional;

@Component
public class ProfissionalMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HorasMesRepository horasMesRepository;

	@Autowired
	private OperacaoRepository operacaoRepository;

	public Profissional toEntity(ProfissionalRequest profissionalRequest) {
		HorasMes horasMes = horasMesRepository.findByMesComp(profissionalRequest.getMesComp());
		profissionalRequest.setHorasMes(horasMes);
		if(profissionalRequest.getIdOperacao() != 0 && profissionalRequest.getIdOperacao() != null){
			Operacao operacao = operacaoRepository.findById(profissionalRequest.getIdOperacao()).get();
			profissionalRequest.setOperacaoPadrao(operacao);
		}
		Profissional profissional = modelMapper.map(profissionalRequest, Profissional.class);
		profissional.setIdProfissional(new ProfissionalId(profissionalRequest.getMatricula(), profissionalRequest.getMesComp()));
		return profissional;
	}

	public Profissional toDto(ProfissionalDTO profissionalDTO) {
		return modelMapper.map(profissionalDTO, Profissional.class);
	}

}