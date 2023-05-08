package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idCliente;
	private String nome;
	private List<Operacao> operacoes;
}
