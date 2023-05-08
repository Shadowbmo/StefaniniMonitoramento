package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.SituacaoParcelaDTO;
import com.stefanini.stfinancial.model.SituacaoParcela;
import com.stefanini.stfinancial.request.SituacaoParcelaRequest;

@Component
public class SituacaoParcelaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SituacaoParcela toEntity(SituacaoParcelaRequest situacaoParcelaRequest) {
		return modelMapper.map(situacaoParcelaRequest, SituacaoParcela.class);
	}
	
	public SituacaoParcela toDto(SituacaoParcelaDTO situacaoParcelaDTO) {
		return modelMapper.map(situacaoParcelaDTO, SituacaoParcela.class);
	}
	
}