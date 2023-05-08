package com.stefanini.stfinancial.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
	
	private Long id;
	private String nome;
	private Integer isAdmin;
	
}
