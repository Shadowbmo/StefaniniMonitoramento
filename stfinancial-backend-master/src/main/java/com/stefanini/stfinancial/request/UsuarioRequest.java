package com.stefanini.stfinancial.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idUsuario;
	private String nome;
	private String senha;
	//vai setar no body request ?
	private Integer isAdmin;

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(nome,senha);
	}
}
