package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idCliente;
	private String nomeFantasia;
	private List<Operacao> operacoes;
}
