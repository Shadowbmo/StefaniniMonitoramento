package com.stefanini.stfinancial.service;

import java.util.List;

import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Usuario;
import com.stefanini.stfinancial.repository.UsuarioRepository;
import com.stefanini.stfinancial.request.UsuarioRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	@Autowired
	private final UsuarioRepository repo;

	public Usuario findByNomeSenha(UsuarioRequest usuario) {
		return repo.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
	}

	public Usuario findByIdUsuario(Long id) {
		return repo.findByIdUsuario(id);
	}

	public Usuario inserirUsuario(Usuario usuario) {
		return repo.save(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return repo.findAll();
	}

	public Usuario alterarUsuario(Usuario usuario) {
		return repo.save(usuario);
	}
	public Usuario alterarUsuario(Usuario usuario, Usuario newUsuario) {
//		Usuario usuario = findByIdUsuario(id);

		if (null != newUsuario) {
			try {
				Usuario usuarioAlterado = preparaAlterar(usuario, newUsuario);
				return repo.save(usuarioAlterado);
			} catch (Exception e) {
				throw new IntegrationException("Erro ao alterar usuario");
			}
		} else {
			return null;
		}
	}

	public String deletarUsuario(Long id) {
		repo.deleteById(id);
		return "Usuário id " + id + " deletado com sucesso";
	}

	public Usuario preparaAlterar(Usuario usuario, Usuario newUsuario) {
		usuario.setSenha(newUsuario.getSenha());
		usuario.setIsAdmin(newUsuario.getIsAdmin());
		return usuario;
	}

}
