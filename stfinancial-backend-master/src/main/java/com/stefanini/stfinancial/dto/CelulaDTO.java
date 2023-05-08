package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.model.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelulaDTO implements Serializable{

	private static final long serialVersionUID = 6017547239678754027L;

	private Long idCelula;
	private String descricao;
	private List<Operacao> operacoes;
}
