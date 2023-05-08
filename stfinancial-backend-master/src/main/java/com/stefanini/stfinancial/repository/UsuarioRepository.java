package com.stefanini.stfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.stfinancial.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	 Usuario findByNomeAndSenha(String nome, String senha);
	 Usuario findByIdUsuario(Long id);

	Optional<Usuario> findByNome(String nome);
}
