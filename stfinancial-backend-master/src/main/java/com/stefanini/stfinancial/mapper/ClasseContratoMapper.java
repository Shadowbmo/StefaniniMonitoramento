package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.ClasseContratoDTO;
import com.stefanini.stfinancial.model.ClasseContrato;
import com.stefanini.stfinancial.request.ClasseContratoRequest;

@Component
public class ClasseContratoMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClasseContrato toEntity(ClasseContratoRequest classeContratoRequest) {
		return modelMapper.map(classeContratoRequest, ClasseContrato.class);
	}
	
	public ClasseContrato toDto(ClasseContratoDTO classeContratoDTO) {
		return modelMapper.map(classeContratoDTO, ClasseContrato.class);
	}
	
}