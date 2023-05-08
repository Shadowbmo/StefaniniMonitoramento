package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Contrato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseContratoRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long cdClasseContrato;
	private String nomeClasseContrato;
	private String descricaoClasseContrato;
	private List<Contrato> contratos;
	
}
