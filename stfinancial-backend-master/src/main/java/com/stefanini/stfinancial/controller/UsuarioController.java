package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.stfinancial.dto.response.UsuarioResponse;
import com.stefanini.stfinancial.mapper.UsuarioMapper;
import com.stefanini.stfinancial.model.Usuario;
import com.stefanini.stfinancial.request.UsuarioRequest;
import com.stefanini.stfinancial.service.UsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/stfinancial/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private UsuarioMapper mapper;

	@RequestMapping(value="/consultar-nome-senha", method = RequestMethod.POST)
    public ResponseEntity<UsuarioResponse> getByLoginAndSenha(@RequestBody UsuarioRequest request) {
		Usuario usu = service.findByNomeSenha(request);
		UsuarioResponse response = mapper.toDto(usu);
		return ResponseEntity.ok().body(response);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getByIdUsuario(@PathVariable Long id) {
		Usuario usu = service.findByIdUsuario(id);
		return ResponseEntity.ok(usu);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioRequest request) {
		Optional<Usuario> user = repo.findByNome(request.getNome());
		if(user.isEmpty()) {
			Usuario usu = mapper.toEntity(request);
			return ResponseEntity.ok(service.inserirUsuario(usu));
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterarUsuario(@PathVariable String username, @RequestBody UsuarioRequest request) {
		Optional<Usuario> usu = repo.findByNome(username);
		Usuario newUsu = mapper.toEntity(request);
//		if (service.findByIdNome(id) == null) {
//			return ResponseEntity.notFound().build();
//		}
		if(usu.isPresent()) {
			Usuario usuario = service.alterarUsuario(usu.get(), newUsu);
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
		// mapper toResponse
		return ResponseEntity.ok(service.deletarUsuario(id));
	}
}
