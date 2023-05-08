package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.CelulaDTO;
import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.request.CelulaRequest;
import com.stefanini.stfinancial.request.CelulaSaveRequest;

@Component
public class CelulaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Celula toEntity(CelulaRequest celulaRequest) {
		return modelMapper.map(celulaRequest, Celula.class);
	}
	
	public Celula toEntitySave(CelulaSaveRequest celulaRequest) {
		return modelMapper.map(celulaRequest, Celula.class);
	}
	public Celula toDto(CelulaDTO celulaDTO) {
		return modelMapper.map(celulaDTO, Celula.class);
	}
	
}