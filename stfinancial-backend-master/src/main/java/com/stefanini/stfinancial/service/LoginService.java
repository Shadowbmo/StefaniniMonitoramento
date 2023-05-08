package com.stefanini.stfinancial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Usuario;
import com.stefanini.stfinancial.repository.UsuarioRepository;
import com.stefanini.stfinancial.request.UsuarioRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {
	
	@Autowired
	private final UsuarioRepository repo;
	
	public Boolean findByNomeSenha(UsuarioRequest login) {
		Usuario user = repo.findByNomeAndSenha(login.getNome(), login.getSenha());
		if(null != user ) {
			return true;
		}else {
			return false;
		}
	}
}
