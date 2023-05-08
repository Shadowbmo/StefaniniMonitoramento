package com.stefanini.stfinancial.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.response.UsuarioResponse;
import com.stefanini.stfinancial.model.Usuario;
import com.stefanini.stfinancial.request.UsuarioRequest;
//import com.stefanini.stfinancial.request.UsuarioSaveRequest;

@Component
public class UsuarioMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toEntity(UsuarioRequest usuarioRequest) {
		usuarioRequest.setSenha(new BCryptPasswordEncoder().encode(usuarioRequest.getSenha()));
		return modelMapper.map(usuarioRequest, Usuario.class);
	}
	
//	public Usuario toEntitySave(UsuarioSaveRequest usuarioRequest) {
//		return modelMapper.map(usuarioRequest, Usuario.class);
//	}
	public UsuarioResponse toDto(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioResponse.class);
	}
	
}