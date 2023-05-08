package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stefanini.stfinancial.dto.ClienteDTO;
import com.stefanini.stfinancial.model.Cliente;
import com.stefanini.stfinancial.request.ClienteRequest;

@Component
public class ClienteMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toEntity(ClienteRequest clienteRequest) {
		return modelMapper.map(clienteRequest, Cliente.class);
	}
	
	public Cliente toEntitySave(ClienteRequest clienteRequest) {
		return modelMapper.map(clienteRequest, Cliente.class);
	}
	public Cliente toDto(ClienteDTO clienteDTO) {
		return modelMapper.map(clienteDTO, Cliente.class);
	}
	
}