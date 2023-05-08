package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.HorasMesDTO;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.request.HorasMesRequest;
import com.stefanini.stfinancial.request.HorasMesSaveRequest;

@Component
public class HorasMesMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public HorasMes toEntity(HorasMesRequest horasMesRequest) {
		return modelMapper.map(horasMesRequest, HorasMes.class);
	}
	
	public HorasMes toEntitySave(HorasMesSaveRequest horasMesRequest) {
		return modelMapper.map(horasMesRequest, HorasMes.class);
	}
	public HorasMes toDto(HorasMesDTO horasMesDTO) {
		return modelMapper.map(horasMesDTO, HorasMes.class);
	}
	
}